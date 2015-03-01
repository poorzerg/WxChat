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
package org.poorzerg.weixin.bean.msg.in;

import org.poorzerg.weixin.bean.msg.Msg;

public class VideoInMsg extends Msg {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "video";
	private String MediaId;
	private String ThumbMediaId;
	private long MsgId;

	public VideoInMsg(InMsg inMsg) {
		if (!inMsg.isVideo()) {
			throw new IllegalArgumentException("the inMsg type should be "
					+ MsgType);
		}
		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.MediaId = inMsg.getMediaId();
		this.ThumbMediaId = inMsg.getThumbMediaId();
		this.MsgId = inMsg.getMsgId();
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public String getMediaId() {
		return MediaId;
	}

	public long getMsgId() {
		return MsgId;
	}

	public String getMsgType() {
		return MsgType;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public String getToUserName() {
		return ToUserName;
	}
}
