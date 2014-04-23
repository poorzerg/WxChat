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
package org.poorzerg.weixin.bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Poorzerg
 * @date 2014年4月23日 下午4:40:14
 */
public class MenuTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateFromJson() {
		String json = "{\"button\":[{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":\"V1001_TODAY_SINGER\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\",\"sub_button\":[]},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\",\"sub_button\":[]},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"赞一下我们0\",\"key\":\"V1001_GOOD\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"赞一下我们1\",\"key\":\"V1001_GOOD\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"赞一下我们2\",\"key\":\"V1001_GOOD\",\"sub_button\":[]}]}]}";
		Menu menu = Menu.createFromJson(json);
		System.out.println(menu);
	}

	@Test
	public void testCreateToJson() {
		Menu menu = new Menu();
		menu.addClickButton("今日歌曲", "V1001_TODAY_MUSIC");
		menu.addClickButton("歌手简介", "V1001_TODAY_SINGER");
		System.out.println(menu.toJson());
	}

}
