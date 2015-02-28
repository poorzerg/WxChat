package org.poorzerg.weixin.bean.msg.in;

public class LocationInMsg {
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
