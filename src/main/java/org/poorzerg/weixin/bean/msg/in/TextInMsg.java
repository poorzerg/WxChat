package org.poorzerg.weixin.bean.msg.in;

public class TextInMsg {
	private String Content;

	private long CreateTime;

	private String FromUserName;

	private long MsgId;

	private String MsgType = "text";

	private String ToUserName;

	public TextInMsg(InMsg inMsg) {
		if (!inMsg.isText()) {
			throw new IllegalArgumentException("the inMsg type should be "
					+ MsgType);
		}
		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.MsgId = inMsg.getMsgId();
		this.Content = inMsg.getContent();
	}

	public String getContent() {
		return Content;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public long getMsgId() {
		return MsgId;
	}

	public String getMsgType() {
		return MsgType;
	}

	public String getToUserName() {
		return ToUserName;
	}
}