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

import org.poorzerg.weixin.bean.msg.Msg;
import org.poorzerg.weixin.bean.msg.in.InMsg;
import org.poorzerg.weixin.type.EventType;

public class EventInMsg extends Msg {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "event";
	private String Event;
	private String EventKey;
	private String Ticket;
	private String Latitude;
	private String Longitude;
	private String Precision;
	private long MsgId;

	public EventInMsg(InMsg inMsg) {
		if (!inMsg.isEvent()) {
			throw new IllegalArgumentException("the inMsg type should be "
					+ MsgType);
		}
		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.MsgId = inMsg.getMsgId();
		this.Event = inMsg.getEvent();
		this.EventKey = inMsg.getEventKey();
		this.Ticket = inMsg.getTicket();
		this.Latitude = inMsg.getLatitude();
		this.Longitude = inMsg.getLongitude();
		this.Precision = inMsg.getPrecision();
		this.MsgId = inMsg.getMsgId();
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

	public String getLatitude() {
		return Latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public long getMsgId() {
		return MsgId;
	}

	public String getMsgType() {
		return MsgType;
	}

	public String getPrecision() {
		return Precision;
	}

	public String getTicket() {
		return Ticket;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public boolean isClickEvent() {
		return this.Event.equals(EventType.CLICK.getName());
	}

	public boolean isLocationEvent() {
		return this.Event.equals(EventType.LOCATION.getName());
	}

	public boolean isScanEvent() {
		return this.Event.equals(EventType.SCAN.getName());
	}

	public boolean isSubscribeEvent() {
		return this.Event.equals(EventType.SUBSCRIBE.getName());
	}

	public boolean isUnsubscribeEvent() {
		return this.Event.equals(EventType.UNSUBSCRIBE.getName());
	}

	public boolean isViewEvent() {
		return this.Event.equals(EventType.VIEW.getName());
	}
}
