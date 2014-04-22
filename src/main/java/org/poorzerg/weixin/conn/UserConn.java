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

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.poorzerg.weixin.bean.AccessToken;
import org.poorzerg.weixin.bean.FollwersInfo;
import org.poorzerg.weixin.bean.UserInfo;
import org.poorzerg.weixin.bean.msg.ErrCodeMsg;
import org.poorzerg.weixin.utils.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户操作接口
 * 
 */
public class UserConn {
	private static final Logger LOG = LoggerFactory.getLogger(UserConn.class);

	private static final String USER_INFO_URI = "https://api.weixin.qq.com/cgi-bin/user/info";
	private static final String USER_GET_URI = "https://api.weixin.qq.com/cgi-bin/user/get";

	/**
	 * 拉取单个用户信息
	 * 
	 * @param accessToken
	 * @param openid
	 *            用户唯一标示符
	 * @return 查询失败时返回null
	 * @throws Exception
	 */
	public UserInfo getUserInfo(AccessToken accessToken, String openid)
			throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken.getAccessToken());
		params.put("openid", openid);
		String jsonStr = Http.get(USER_INFO_URI, params);
		if (StringUtils.isNotEmpty(jsonStr)) {
			JSONObject obj = JSONObject.fromObject(jsonStr);
			if (obj.get("errcode") != null) {
				ErrCodeMsg eCode = new ErrCodeMsg(obj);
				LOG.error("get the user info error! openid:[?], errMsg:[?]",
						openid, eCode.toString());
				return null;
			}
			UserInfo user = (UserInfo) JSONObject.toBean(
					JSONObject.fromObject(obj), UserInfo.class);
			return user;
		}
		return null;
	}

	/**
	 * 获取帐号的所有关注者列表
	 * 
	 * @param accessToken
	 * @param next_openid
	 * @return 查询失败时，返回null
	 * @throws Exception
	 */
	public FollwersInfo getFollwersList(AccessToken accessToken,
			String next_openid) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken.getAccessToken());
		params.put("next_openid", next_openid);
		String jsonStr = Http.get(USER_GET_URI, params);
		if (StringUtils.isNotEmpty(jsonStr)) {
			JSONObject obj = JSONObject.fromObject(jsonStr);
			if (obj.get("errcode") != null) {
				ErrCodeMsg eCode = new ErrCodeMsg(obj);
				LOG.error(
						"get the follwers info error! next_openid:[?], errMsg:[?]",
						next_openid, eCode.toString());
				return null;
			}
			return (FollwersInfo) JSONObject.toBean(obj, FollwersInfo.class);
		}
		return null;
	}

}