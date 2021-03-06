/**
 * 
 * https://github.com/poorzerg/WxChat
 *
 * Copyright 2010-2014 Guoqiang Chen. All rights reserved.
 * Email: poorzerg@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.poorzerg.weixin.process;

import org.poorzerg.weixin.bean.msg.in.event.EventInMsg;
import org.poorzerg.weixin.bean.msg.out.OutMsg;
import org.poorzerg.weixin.bean.msg.out.TextOutMsg;

/**
 * 默认事件消息处理器
 * 
 * @author Poorzerg
 *
 */
public class DefaultEventProcess {

	public OutMsg process(EventInMsg eventInMsg) {
		if (eventInMsg.isSubscribeEvent()) {

		} else if (eventInMsg.isUnsubscribeEvent()) {

		} else if (eventInMsg.isScanEvent()) {

		} else if (eventInMsg.isLocationEvent()) {

		} else if (eventInMsg.isClickEvent()) {

		} else if (eventInMsg.isViewEvent()) {

		} else {
			// TODO undefine type
		}

		// FIXME just for test
		return new TextOutMsg("我已经接收到您的event消息了，事件是[" + eventInMsg.getEvent()
				+ "]");
	}
}
