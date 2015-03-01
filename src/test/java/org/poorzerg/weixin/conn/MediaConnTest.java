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

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.poorzerg.weixin.BaseTest;
import org.poorzerg.weixin.WeixinChat;
import org.poorzerg.weixin.bean.MediaInfo;
import org.poorzerg.weixin.type.MediaType;
import org.poorzerg.weixin.utils.Attachment;

/**
 * 
 * @author Poorzerg
 * @date 2014年4月22日 下午3:32:16
 */
public class MediaConnTest extends BaseTest {
	private MediaConn mc = WeixinChat.media;

	public MediaConnTest() throws Exception {
		super();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUploadMediaGt128KB() throws Exception {
		MediaInfo mInfo = mc.uploadMedia(accessToken,
				MediaType.IMAGE.getValue(), new File(
						"src/test/resources/image/001.jpg"));
		assertNull(mInfo);
	}

	@Test
	public void testUploadMediaAndGet() throws Exception {
		MediaInfo mInfo = mc.uploadMedia(accessToken,
				MediaType.IMAGE.getValue(), new File(
						"src/test/resources/image/002.jpg"));
		assertNotNull(mInfo);
		Attachment attach = mc.getMedia(accessToken, mInfo.getMedia_id());
		assertNotNull(attach);
	}

	@Test
	public void testGetMediaByErrorMediaId() throws IOException {
		Attachment attach = mc.getMedia(accessToken, "001");
		assertNotNull(attach);
		assertEquals(40007, attach.getErrCode().getErrcode());
	}

}
