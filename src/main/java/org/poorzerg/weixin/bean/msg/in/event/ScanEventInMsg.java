package org.poorzerg.weixin.bean.msg.in.event;

public class ScanEventInMsg {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "event";
	private String Event = "SCAN";
	private String EventKey;
	private String Ticket;

	public ScanEventInMsg(EventInMsg inMsg) {
		if (!inMsg.isScanEvent()) {
			throw new IllegalArgumentException("the eventInMsg type should be "
					+ Event);
		}
		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.EventKey = inMsg.getEventKey();
		this.Ticket = inMsg.getTicket();
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

	public String getEventKey() {
		return EventKey;
	}

	public String getTicket() {
		return Ticket;
	}
}
