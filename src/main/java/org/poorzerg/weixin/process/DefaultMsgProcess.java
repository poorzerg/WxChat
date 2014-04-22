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

public class DefaultMsgProcess implements MsgProcess {
	private OutMsg outMsg;

	@Override
	public void allType(InMsg msg) {
		TextOutMsg out = new TextOutMsg("我已经接收到您的[" + msg.getMsgType()
				+ "]消息了！");
		setOutMsg(out);
	}

	@Override
	public void textMsg(InMsg msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void locationMsg(InMsg msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void imageMsg(InMsg msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void videoMsg(InMsg msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void linkMsg(InMsg msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void voiceMsg(InMsg msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void eventMsg(InMsg msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterProcess(InMsg inMsg, OutMsg outMsg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setOutMsg(OutMsg outMsg) {
		this.outMsg = outMsg;
	}

	@Override
	public OutMsg getOutMessage() {
		return outMsg;
	}

}
