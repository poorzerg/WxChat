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
package org.poorzerg.weixin.bean.msg;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 所有的InMsg汇聚为一个来处理
 * 
 * @author Poorzerg
 * 
 */
@XStreamAlias("xml")
public class InMsg {
	private String tokenKey;

	private String ToUserName;

	private String FromUserName;

	private long CreateTime;

	private String MsgType = "text";
	private long MsgId;

	// 文本消息
	private String Content;

	// 图片消息
	private String PicUrl;

	private String MediaId;

	// 语音信息
	private String Format;

	// 视频消息
	private String ThumbMediaId;

	// 位置消息
	private String Location_X;

	private String Location_Y;

	private long Scale;
	private String Label;

	// 链接消息
	private String Title;
	private String Description;

	private String Url;
	// 事件
	private String Event;
	private String EventKey;

	private String Ticket;
	private String Latitude;
	private String Longitude;

	private String Precision;

	public String getContent() {
		return Content;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public String getDescription() {
		return Description;
	}

	public String getEvent() {
		return Event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public String getFormat() {
		return Format;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public String getLabel() {
		return Label;
	}

	public String getLatitude() {
		return Latitude;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public String getLongitude() {
		return Longitude;
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

	public String getPicUrl() {
		return PicUrl;
	}

	public String getPrecision() {
		return Precision;
	}

	public long getScale() {
		return Scale;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public String getTicket() {
		return Ticket;
	}

	public String getTitle() {
		return Title;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public String getUrl() {
		return Url;
	}

	public Boolean isEvent() {
		return this.MsgType.equals(org.poorzerg.weixin.type.MsgType.EVENT
				.getName());
	}

	public Boolean isImage() {
		return this.MsgType.equals(org.poorzerg.weixin.type.MsgType.IMAGE
				.getName());
	}

	public Boolean isLink() {
		return this.MsgType.equals(org.poorzerg.weixin.type.MsgType.LINK
				.getName());
	}

	public Boolean isLocation() {
		return this.MsgType.equals(org.poorzerg.weixin.type.MsgType.LOCATION
				.getName());
	}

	public Boolean isText() {
		return this.MsgType.equals(org.poorzerg.weixin.type.MsgType.TEXT
				.getName());
	}

	public Boolean isVideo() {
		return this.MsgType.equals(org.poorzerg.weixin.type.MsgType.VIDEO
				.getName());
	}

	public Boolean isVoice() {
		return this.MsgType.equals(org.poorzerg.weixin.type.MsgType.VOICE
				.getName());
	}

	public void setContent(String content) {
		Content = content;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	public void setScale(long scale) {
		Scale = scale;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public void setUrl(String url) {
		Url = url;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
