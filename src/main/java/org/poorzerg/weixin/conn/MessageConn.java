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

import org.poorzerg.weixin.bean.AccessToken;
import org.poorzerg.weixin.bean.msg.ErrCodeMsg;
import org.poorzerg.weixin.utils.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * 客服消息接口
 * 
 * @author L.cm
 * @date 2013-11-5 下午3:32:30
 */
public class MessageConn {
	private static final Logger LOG = LoggerFactory
			.getLogger(MessageConn.class);
	private static final String MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";

	/**
	 * 发送文本客服消息
	 * 
	 * @param accessToken
	 * @param openid
	 * @param text
	 * @return
	 * @throws Exception
	 */
	public boolean sendText(AccessToken accessToken, String openid, String text)
			throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		Map<String, Object> textObj = new HashMap<String, Object>();
		textObj.put("content", text);
		json.put("touser", openid);
		json.put("msgtype", "text");
		json.put("text", textObj);
		String post = JSONObject.fromObject(json).toString();
		String reslut = Http.post(
				MESSAGE_URL.concat(accessToken.getAccessToken()), post);
		JSONObject obj = JSONObject.fromObject(reslut);
		ErrCodeMsg eCode = new ErrCodeMsg(obj);
		if (eCode.getErrcode() != 0) {
			LOG.error(
					"send the text msg error! openid:[{}], text:[{}], errMsg:[{}]",
					openid, text, eCode.toString());
			return false;
		}
		return true;
	}

	/**
	 * 发送照片客服消息
	 * 
	 * @param accessToken
	 * @param openid
	 * @param media_id
	 * @return
	 * @throws Exception
	 */
	public boolean sendImage(AccessToken accessToken, String openid,
			String media_id) throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		Map<String, Object> imageObj = new HashMap<String, Object>();
		imageObj.put("media_id", media_id);
		json.put("touser", openid);
		json.put("msgtype", "image");
		json.put("image", imageObj);
		String post = JSONObject.fromObject(json).toString();
		String reslut = Http.post(
				MESSAGE_URL.concat(accessToken.getAccessToken()), post);
		JSONObject obj = JSONObject.fromObject(reslut);
		ErrCodeMsg eCode = new ErrCodeMsg(obj);
		if (eCode.getErrcode() != 0) {
			LOG.error(
					"send the image msg error! openid:[{}], media_id:[{}],errMsg:[{}]",
					openid, media_id, eCode.toString());
			return false;
		}
		return true;
	}
}
