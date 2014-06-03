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

import org.poorzerg.weixin.bean.msg.InMsg;
import org.poorzerg.weixin.bean.msg.out.OutMsg;
import org.poorzerg.weixin.bean.msg.out.TextOutMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultMsgProcess implements MsgProcess {
	private static final Logger LOG = LoggerFactory.getLogger(MsgProcess.class);

	@Override
	public OutMsg allType(InMsg msg) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("inMsg:[{}]", msg.toXml());
		}

		return new TextOutMsg("我已经接收到您的[" + msg.getMsgType() + "]消息了！");
	}

	@Override
	public OutMsg textMsg(InMsg in, OutMsg out) {
		// TODO Auto-generated method stub
		return out;
	}

	@Override
	public OutMsg locationMsg(InMsg in, OutMsg out) {
		// TODO Auto-generated method stub
		return out;
	}

	@Override
	public OutMsg imageMsg(InMsg in, OutMsg out) {
		// TODO Auto-generated method stub
		return out;
	}

	@Override
	public OutMsg videoMsg(InMsg in, OutMsg out) {
		// TODO Auto-generated method stub
		return out;
	}

	@Override
	public OutMsg linkMsg(InMsg in, OutMsg out) {
		// TODO Auto-generated method stub
		return out;
	}

	@Override
	public OutMsg voiceMsg(InMsg in, OutMsg out) {
		// TODO Auto-generated method stub
		return out;
	}

	@Override
	public OutMsg eventMsg(InMsg in, OutMsg out) {
		// TODO Auto-generated method stub
		return out;
	}

	@Override
	public OutMsg afterProcess(InMsg in, OutMsg out) {
		// TODO Auto-generated method stub
		return out;
	}
}
