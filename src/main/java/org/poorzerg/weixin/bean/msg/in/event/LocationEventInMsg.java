package org.poorzerg.weixin.bean.msg.in.event;

public class LocationEventInMsg {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "event";
	private String Event = "LOCATION";
	private String Latitude;
	private String Longitude;
	private String Precision;

	public LocationEventInMsg(EventInMsg inMsg) {
		if (!inMsg.isLocationEvent()) {
			throw new IllegalArgumentException("the eventInMsg type should be "
					+ Event);
		}
		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.Latitude = inMsg.getLatitude();
		this.Longitude = inMsg.getLongitude();
		this.Precision = inMsg.getPrecision();
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

	public String getEvent() {
		return Event;
	}

	public String getLatitude() {
		return Latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public String getPrecision() {
		return Precision;
	}

}
