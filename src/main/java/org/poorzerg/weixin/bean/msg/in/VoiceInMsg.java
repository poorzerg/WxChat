package org.poorzerg.weixin.bean.msg.in;

import org.poorzerg.weixin.bean.msg.Msg;

public class VoiceInMsg extends Msg {
	private long CreateTime;

	private String Format;

	private String FromUserName;

	private String MediaId;

	private long MsgId;
	private String MsgType = "voice";

	private String ToUserName;

	public VoiceInMsg(InMsg inMsg) {
		if (!inMsg.isVoice()) {
			throw new IllegalArgumentException("the inMsg type should be "
					+ MsgType);
		}

		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.MsgId = inMsg.getMsgId();
		this.MediaId = inMsg.getMediaId();
		this.Format = inMsg.getFormat();
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public String getFormat() {
		return Format;
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

	public String getToUserName() {
		return ToUserName;
	}
}
