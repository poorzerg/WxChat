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

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.poorzerg.weixin.BaseTest;
import org.poorzerg.weixin.WeixinChat;

/**
 * 
 * @author Poorzerg
 * @date 2014年4月22日 下午3:33:09
 */
public class MenuConnTest extends BaseTest {

	private MenuConn menu = WeixinChat.menu;

	public MenuConnTest() throws Exception {
		super();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMenuInfo() throws Exception {
		System.out.println(menu.getMenuInfo(accessToken));
	}

	@Test
	public void testDeleteMenu() {
		fail("Not yet implemented");
	}

}
