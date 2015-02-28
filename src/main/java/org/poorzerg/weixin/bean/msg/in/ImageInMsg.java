package org.poorzerg.weixin.bean.msg.in;

public class ImageInMsg {
	private long CreateTime;
	private String FromUserName;
	private String MediaId;
	private long MsgId;
	private String MsgType = "image";
	private String PicUrl;
	private String ToUserName;

	public ImageInMsg(InMsg inMsg) {
		if (!inMsg.isImage()) {
			throw new IllegalArgumentException("the inMsg type should be "
					+ MsgType);
		}
		this.CreateTime = inMsg.getCreateTime();
		this.FromUserName = inMsg.getFromUserName();
		this.MediaId = inMsg.getMediaId();
		this.MsgId = inMsg.getMsgId();
		this.PicUrl = inMsg.getPicUrl();
		this.ToUserName = inMsg.getToUserName();
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

	public String getPicUrl() {
		return PicUrl;
	}

	public String getToUserName() {
		return ToUserName;
	}
}
