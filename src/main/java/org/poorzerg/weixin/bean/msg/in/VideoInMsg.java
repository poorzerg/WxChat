package org.poorzerg.weixin.bean.msg.in;

import org.poorzerg.weixin.bean.msg.Msg;

public class VideoInMsg extends Msg{
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
