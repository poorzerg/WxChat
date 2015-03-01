package org.poorzerg.weixin.bean.msg.in.event;

public class SubscribeEventInMsg {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "event";
	private String Event = "subscribe";
	private String EventKey;
	private String Ticket;

	public SubscribeEventInMsg(EventInMsg inMsg) {
		if (!inMsg.isSubscribeEvent()) {
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
