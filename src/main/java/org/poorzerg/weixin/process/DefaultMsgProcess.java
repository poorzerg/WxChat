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

import org.poorzerg.weixin.bean.msg.in.ImageInMsg;
import org.poorzerg.weixin.bean.msg.in.InMsg;
import org.poorzerg.weixin.bean.msg.in.LinkInMsg;
import org.poorzerg.weixin.bean.msg.in.LocationInMsg;
import org.poorzerg.weixin.bean.msg.in.TextInMsg;
import org.poorzerg.weixin.bean.msg.in.VideoInMsg;
import org.poorzerg.weixin.bean.msg.in.VoiceInMsg;
import org.poorzerg.weixin.bean.msg.in.event.EventInMsg;
import org.poorzerg.weixin.bean.msg.out.OutMsg;
import org.poorzerg.weixin.bean.msg.out.TextOutMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultMsgProcess implements MsgProcess {
	private static final Logger LOG = LoggerFactory.getLogger(MsgProcess.class);
	private DefaultEventProcess eventProcess = new DefaultEventProcess();

	@Override
	public void allType(InMsg msg) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("inMsg XML:[{}]", msg.toXml());
		}
	}

	@Override
	public OutMsg textMsg(InMsg in) {
		TextInMsg msg = new TextInMsg(in);
		OutMsg outMsg = null;
		if (LOG.isDebugEnabled()) {
			LOG.debug("TextInMsg:[{}]", msg.toString());
			outMsg = new TextOutMsg("我已经接收到您的[" + in.getMsgType() + "]消息了！");
		}
		return outMsg;
	}

	@Override
	public OutMsg locationMsg(InMsg in) {
		LocationInMsg msg = new LocationInMsg(in);
		OutMsg outMsg = null;
		if (LOG.isDebugEnabled()) {
			LOG.debug("LocationInMsg:[{}]", msg.toString());
			outMsg = new TextOutMsg("我已经接收到您的[" + in.getMsgType() + "]消息了！");
		}
		return outMsg;
	}

	@Override
	public OutMsg imageMsg(InMsg in) {
		ImageInMsg msg = new ImageInMsg(in);
		OutMsg outMsg = null;
		if (LOG.isDebugEnabled()) {
			LOG.debug("ImageInMsg:[{}]", msg.toString());
			outMsg = new TextOutMsg("我已经接收到您的[" + in.getMsgType() + "]消息了！");
		}
		return outMsg;
	}

	@Override
	public OutMsg videoMsg(InMsg in) {
		VideoInMsg msg = new VideoInMsg(in);
		OutMsg outMsg = null;
		if (LOG.isDebugEnabled()) {
			LOG.debug("VideoInMsg:[{}]", msg.toString());
			outMsg = new TextOutMsg("我已经接收到您的[" + in.getMsgType() + "]消息了！");
		}
		return outMsg;
	}

	@Override
	public OutMsg linkMsg(InMsg in) {
		LinkInMsg msg = new LinkInMsg(in);
		OutMsg outMsg = null;
		if (LOG.isDebugEnabled()) {
			LOG.debug("LinkInMsg:[{}]", msg.toString());
			outMsg = new TextOutMsg("我已经接收到您的[" + in.getMsgType() + "]消息了！");
		}
		return outMsg;
	}

	@Override
	public OutMsg voiceMsg(InMsg in) {
		VoiceInMsg msg = new VoiceInMsg(in);
		OutMsg outMsg = null;
		if (LOG.isDebugEnabled()) {
			LOG.debug("VoiceInMsg:[{}]", msg.toString());
			outMsg = new TextOutMsg("我已经接收到您的[" + in.getMsgType() + "]消息了！");
		}
		return outMsg;
	}

	@Override
	public OutMsg eventMsg(InMsg in) {
		EventInMsg msg = new EventInMsg(in);
		if (LOG.isDebugEnabled()) {
			LOG.debug("EventInMsg:[{}]", msg.toString());
		}
		return eventProcess.process(msg);
	}

	@Override
	public OutMsg afterProcess(InMsg in, OutMsg out) {
		if (null != out) {
			return out;
		}
		// FIXME just for test
		return new TextOutMsg("After-我已经接收到您的[" + in.getMsgType() + "]消息了！");
	}
}
