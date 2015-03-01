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
package org.poorzerg.weixin.bean.msg.in.event;

public class UnsubscribeEventInMsg {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "event";
	private String Event = "unsubscribe";
	private String EventKey;
	private String Ticket;

	public UnsubscribeEventInMsg(EventInMsg inMsg) {
		if (!inMsg.isUnsubscribeEvent()) {
			throw new IllegalArgumentException("the eventInMsg type should be "
					+ Event);
		}
		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.EventKey = inMsg.getEventKey();
		this.Ticket = inMsg.getTicket();
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public String getEvent() {
		return Event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public String getMsgType() {
		return MsgType;
	}

	public String getTicket() {
		return Ticket;
	}

	public String getToUserName() {
		return ToUserName;
	}

}
