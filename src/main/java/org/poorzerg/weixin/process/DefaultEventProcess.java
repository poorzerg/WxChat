package org.poorzerg.weixin.process;

import org.poorzerg.weixin.bean.msg.in.event.EventInMsg;
import org.poorzerg.weixin.bean.msg.out.OutMsg;
import org.poorzerg.weixin.bean.msg.out.TextOutMsg;

public class DefaultEventProcess {

	public OutMsg process(EventInMsg eventMsg) {
		if (eventMsg.isSubscribeEvent()) {

		} else if (eventMsg.isUnsubscribeEvent()) {

		} else if (eventMsg.isScanEvent()) {

		} else if (eventMsg.isLocationEvent()) {

		} else if (eventMsg.isClickEvent()) {

		} else if (eventMsg.isViewEvent()) {

		} else {
			// TODO undefine type
		}

		// FIXME just for test
		return new TextOutMsg("我已经接收到您的event消息了，事件是[" + eventMsg.getEvent()
				+ "]");
	}
}
