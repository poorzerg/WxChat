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

import org.poorzerg.weixin.bean.AccessToken;
import org.poorzerg.weixin.bean.msg.ErrCodeMsg;
import org.poorzerg.weixin.utils.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Poorzerg
 * @date 2014年4月22日 下午3:19:30
 */
public class AccessTokenConn {
	private static final Logger LOG = LoggerFactory
			.getLogger(AccessTokenConn.class);

	private static final String ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

	/**
	 * 获取access_token
	 * 
	 * @return 如果获取失败，将会返回null
	 * @throws Exception
	 */
	public AccessToken getAccessToken(String appid, String appsecret)
			throws Exception {
		String jsonStr = Http.get(ACCESSTOKEN_URL.concat("&appid=") + appid
				+ "&secret=" + appsecret);

		@SuppressWarnings("unchecked")
		Map<String, Object> map = JSONObject.fromObject(jsonStr);
		String accessToken = (String) map.get("access_token");
		if (null == accessToken) {
			ErrCodeMsg eCode = new ErrCodeMsg();
			eCode.setErrcode(((Integer) map.get("errcode")).intValue());
			eCode.setErrmsg((String) map.get("errmsg"));
			LOG.error(
					"get the accessToken error! appid:[?], appsecret:[?],errMsg:[?]",
					appid, appsecret, eCode.toString());
			return null;
		}

		int expiresIn = ((Integer) map.get("expires_in")).intValue();
		return (new AccessToken(accessToken, expiresIn));
	}

	/**
	 * 验证appid和appsecret的正确性
	 * 
	 * @param appid
	 * @param appsecret
	 * @return
	 * @throws Exception
	 *             表示http链接失败
	 */
	public boolean validateAppidAndAppsecret(String appid, String appsecret)
			throws Exception {
		String jsonStr = Http.get(ACCESSTOKEN_URL.concat("&appid=") + appid
				+ "&secret=" + appsecret);
		JSONObject map = JSONObject.fromObject(jsonStr);
		return null != map.get("access_token");
	}
}
