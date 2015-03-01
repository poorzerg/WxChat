package org.poorzerg.weixin.bean.msg.in;

import org.poorzerg.weixin.bean.msg.Msg;

public class LinkInMsg extends Msg{
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "link";
	private String Title;
	private String Description;
	private String Url;
	private long MsgId;

	public LinkInMsg(InMsg inMsg) {
		if (!inMsg.isLink()) {
			throw new IllegalArgumentException("the inMsg type should be "
					+ MsgType);
		}
		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.Title = inMsg.getTitle();
		this.Description = inMsg.getDescription();
		this.Url = inMsg.getUrl();
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

	public String getTitle() {
		return Title;
	}

	public String getDescription() {
		return Description;
	}

	public String getUrl() {
		return Url;
	}

	public long getMsgId() {
		return MsgId;
	}

}
