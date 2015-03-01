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

public class LocationInMsg extends Msg {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "location";
	private String Location_X;
	private String Location_Y;
	private long Scale;
	private String Label;
	private long MsgId;

	public LocationInMsg(InMsg inMsg) {
		if (!inMsg.isLocation()) {
			throw new IllegalArgumentException("the inMsg type should be "
					+ MsgType);
		}
		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.Location_X = inMsg.getLocation_X();
		this.Location_Y = inMsg.getLocation_Y();
		this.Scale = inMsg.getScale();
		this.Label = inMsg.getLabel();
		this.MsgId = inMsg.getMsgId();
	}

	public String getToUserName() {
		return ToUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public long getScale() {
		return Scale;
	}

	public String getLabel() {
		return Label;
	}

	public long getMsgId() {
		return MsgId;
	}
}
