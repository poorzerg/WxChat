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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.poorzerg.weixin.BaseTest;
import org.poorzerg.weixin.WeixinChat;

/**
 * 
 * @author Poorzerg
 * @date 2014年4月22日 下午3:31:28
 */
public class AccessTokenConnTest extends BaseTest {
	private AccessTokenConn atc = WeixinChat.accessToken;

	public AccessTokenConnTest() throws Exception {
		super();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAccessToken() {
		assertNotNull("can`t get the accessToken", accessToken);
		System.out.println("accessToken:" + accessToken.getAccessToken());
		System.out.println("expiresIn:" + accessToken.getExpiresIn());
	}

	@Test
	public void testValidateAppidAndAppsecret() throws Exception {
		assertTrue(atc.validateAppidAndAppsecret(appid, appsecret));
		assertFalse(atc.validateAppidAndAppsecret(appid + "_0", appsecret));
		assertFalse(atc.validateAppidAndAppsecret(appid, appsecret + "_0"));
		assertFalse(atc.validateAppidAndAppsecret(appid + "_0", appsecret
				+ "_0"));
	}

}
