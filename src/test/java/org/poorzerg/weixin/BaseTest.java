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
package org.poorzerg.weixin;

import org.poorzerg.weixin.bean.AccessToken;
import org.poorzerg.weixin.utils.Config;

/**
 * 
 * @author Poorzerg
 * @date 2014年4月22日 下午2:12:28
 */
public abstract class BaseTest {
	protected String openid;
	protected String appid;
	protected String appsecret;
	protected AccessToken accessToken;

	public BaseTest() throws Exception {
		openid = Config.getString("openid");
		appid = Config.getString("appid");
		appsecret = Config.getString("appsecret");
		accessToken = WeixinChat.accessToken.getAccessToken(appid, appsecret);
	}
}
