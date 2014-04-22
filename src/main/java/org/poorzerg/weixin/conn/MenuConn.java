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

import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.poorzerg.weixin.bean.AccessToken;
import org.poorzerg.weixin.bean.MenuButton;
import org.poorzerg.weixin.bean.msg.ErrCodeMsg;
import org.poorzerg.weixin.utils.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义菜单操作
 * 
 * @author Poorzerg
 * 
 */
public class MenuConn {
	private static final Logger LOG = LoggerFactory.getLogger(MenuConn.class);

	/**
	 * 创建菜单
	 * 
	 * @param accessToken
	 * @param menuButton
	 * @return 
	 * @throws Exception
	 */
	public boolean createMenu(AccessToken accessToken, MenuButton menuButton)
			throws Exception {
		String result = Http.post(
				"https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
						+ accessToken.getAccessToken(), menuButton.toJson());
		if (StringUtils.isNotBlank(result)) {
			JSONObject obj = JSONObject.fromObject(result);
			ErrCodeMsg eCode = new ErrCodeMsg(obj);
			if (eCode.getErrcode() != 0) {
				LOG.error("create the menu error! menuJson:[{}], errMsg:[{}]",
						menuButton.toJson(), eCode.toString());
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 查询菜单
	 * 
	 * @throws Exception
	 */
	public Map<String, Object> getMenuInfo(AccessToken accessToken)
			throws Exception {

		// TODO 待封装处理
		String result = Http
				.get("https://api.weixin.qq.com/cgi-bin/menu/get?access_token="
						+ accessToken.getAccessToken());
		@SuppressWarnings("unchecked")
		Map<String, Object> map = JSONObject.fromObject(result);
		return map;
	}

	/**
	 * 删除自定义菜单
	 * 
	 * @param accessToken
	 * @return 
	 * @throws Exception
	 */
	public boolean deleteMenu(AccessToken accessToken) throws Exception {
		String result = Http
				.get("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="
						+ accessToken.getAccessToken());
		if (StringUtils.isNotBlank(result)) {
			ErrCodeMsg eCode = new ErrCodeMsg(JSONObject.fromObject(result));
			if (eCode.getErrcode() != 0) {
				LOG.error("delete the menu error! errMsg:[{}]"
						+ eCode.toString());
				return false;
			}
			return true;
		}
		return false;
	}
}
