package org.poorzerg.weixin.bean.msg.in.event;

public class UnsubscribeEventInMsg {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType = "event";
	private String Event = "unsubscribe";
	private String EventKey;
	private String Ticket;

	public UnsubscribeEventInMsg(EventInMsg inMsg) {
		if (!inMsg.isUnsubscribeEvent()) {
			throw new IllegalArgumentException("the eventInMsg type should be "
					+ Event);
		}
		this.ToUserName = inMsg.getToUserName();
		this.FromUserName = inMsg.getFromUserName();
		this.CreateTime = inMsg.getCreateTime();
		this.EventKey = inMsg.getEventKey();
		this.Ticket = inMsg.getTicket();
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public String getEvent() {
		return Event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public String getMsgType() {
		return MsgType;
	}

	public String getTicket() {
		return Ticket;
	}

	public String getToUserName() {
		return ToUserName;
	}

}
