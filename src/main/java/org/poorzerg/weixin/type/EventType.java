package org.poorzerg.weixin.type;

public enum EventType {

	SUBSCRIBE("subscribe"), //
	UNSUBSCRIBE("unsubscribe"), //
	SCAN("SCAN"), //
	LOCATION("LOCATION"), //
	CLICK("CLICK"), //
	VIEW("VIEW");

	private String name;

	private EventType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
