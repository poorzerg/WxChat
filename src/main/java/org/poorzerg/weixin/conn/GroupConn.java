/**
 * 
 * https://github.com/poorzerg/WxChat
 *
 * Copyright 2010-2014 Guoqiang Chen. All rights reserved.
 * Email: poorzerg@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.poorzerg.weixin.conn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.poorzerg.weixin.bean.AccessToken;
import org.poorzerg.weixin.bean.GroupInfo;
import org.poorzerg.weixin.bean.msg.ErrCodeMsg;
import org.poorzerg.weixin.utils.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户操作接口
 * 
 * @author Poorzerg
 */
public class GroupConn {
	private static final Logger LOG = LoggerFactory.getLogger(GroupConn.class);

	private static final String GROUP_CREATE_URI = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=";
	private static final String GROUP_GET_URI = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=";
	private static final String GROUP_GETID_URI = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=";
	private static final String GROUP_UPDATE_URI = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=";
	private static final String GROUP_MEMBERS_UPDATE_URI = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";

	/**
	 * 创建分组
	 * 
	 * @param accessToken
	 * @param groupName
	 *            分组名字（30个字符以内）
	 * @return 如果查询失败时，返回null
	 * @throws Exception
	 */
	public GroupInfo create(AccessToken accessToken, String groupName)
			throws Exception {
		Map<String, Object> group = new HashMap<String, Object>();
		Map<String, Object> nameObj = new HashMap<String, Object>();
		nameObj.put("name", groupName);
		group.put("group", nameObj);
		String reslut = Http.post(
				GROUP_CREATE_URI.concat(accessToken.getAccessToken()),
				JSONObject.fromObject(group).toString());
		if (StringUtils.isNotEmpty(reslut)) {
			JSONObject obj = JSONObject.fromObject(reslut);
			if (obj.get("errcode") != null) {
				ErrCodeMsg eCode = new ErrCodeMsg(obj);
				LOG.error("create group error!groupName:[{}], errMsg:[{}]",
						groupName, eCode.toString());
				return null;
			}

			return (GroupInfo) JSONObject.toBean(obj.getJSONObject("group"),
					GroupInfo.class);
		}
		return null;
	}

	/**
	 * 查询所有分组
	 * 
	 * @param accessToken
	 * @return 查询失败，返回null
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<GroupInfo> get(AccessToken accessToken) throws Exception {
		String reslut = Http.get(GROUP_GET_URI.concat(accessToken
				.getAccessToken()));

		if (StringUtils.isNotEmpty(reslut)) {

			JSONObject obj = JSONObject.fromObject(reslut);
			if (obj.get("errcode") != null) {
				ErrCodeMsg eCode = new ErrCodeMsg(obj);
				LOG.error("get the all group info error!errMsg:[{}]",
						eCode.toString());
				return null;
			}

			return new ArrayList<GroupInfo>(JSONArray.toCollection(
					obj.getJSONArray("groups"), GroupInfo.class));
		}
		return null;
	}

	/**
	 * 查询用户所在分组
	 * 
	 * @param accessToken
	 * @param openid
	 *            用户的OpenID
	 * @return 用户所处的groupId，如果查询失败，返回-1
	 * @throws Exception
	 */
	public int memberIn(AccessToken accessToken, String openid)
			throws Exception {
		String reslut = Http.post(
				GROUP_GETID_URI.concat(accessToken.getAccessToken()),
				"{\"openid\":\"" + openid + "\"}");
		if (StringUtils.isNotEmpty(reslut)) {
			JSONObject obj = JSONObject.fromObject(reslut);
			if (obj.get("errcode") != null) {
				ErrCodeMsg eCode = new ErrCodeMsg(obj);
				LOG.error(
						"check the member in group error!openid:[{}], errMsg:[{}]",
						openid, eCode.toString());
				return -1;
			}
			return obj.getInt("group");
		}

		return -1;
	}

	/**
	 * 修改分组名
	 * 
	 * @param accessToken
	 * @param id
	 *            分组id，由微信分配
	 * @param name
	 *            分组名字（30个字符以内）
	 * @return
	 * @throws Exception
	 */
	public boolean updateName(AccessToken accessToken, String id, String name)
			throws Exception {
		Map<String, Object> group = new HashMap<String, Object>();
		Map<String, Object> nameObj = new HashMap<String, Object>();
		nameObj.put("name", name);
		nameObj.put("id", id);
		group.put("group", nameObj);
		String post = JSONObject.fromObject(group).toString();
		String reslut = Http.post(
				GROUP_UPDATE_URI.concat(accessToken.getAccessToken()), post);
		if (StringUtils.isNotEmpty(reslut)) {
			JSONObject obj = JSONObject.fromObject(reslut);
			ErrCodeMsg eCode = new ErrCodeMsg(obj);

			if (eCode.getErrcode() != 0) {
				LOG.error(
						"update the group name error! groupId:[{}], updateName:[{}], errMsg:[{}]",
						id, name, eCode.toString());
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 移动用户分组
	 * 
	 * @param accessToken
	 * @param openid
	 *            用户唯一标识符
	 * @param toGroupid
	 *            分组id
	 * @return
	 * @throws Exception
	 */
	public boolean memberMove(AccessToken accessToken, String openid,
			int toGroupid) throws Exception {
		String reslut = Http.post(
				GROUP_MEMBERS_UPDATE_URI.concat(accessToken.getAccessToken()),
				"{\"openid\":\"" + openid + "\",\"to_groupid\":" + toGroupid
						+ "}");
		if (StringUtils.isNotEmpty(reslut)) {
			JSONObject obj = JSONObject.fromObject(reslut);
			ErrCodeMsg eCode = new ErrCodeMsg(obj);

			if (eCode.getErrcode() != 0) {
				LOG.error(
						"move the member to the group error! openid:[{}], toGroupid:[{}], errMsg:[{}]",
						openid, toGroupid, eCode.toString());
				return false;
			}
			return true;
		}
		return false;
	}

}