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

public interface MsgProcess {
	/**
	 * 统一处理器
	 * 
	 * @param msg
	 * @return
	 */
	public void allType(InMsg msg);

	/**
	 * 文字内容的消息处理
	 * 
	 * @param msg
	 * @return
	 */
	public void textMsg(InMsg msg);

	/**
	 * 地理位置类型的消息处理
	 * 
	 * @param msg
	 * @return
	 */
	public void locationMsg(InMsg msg);

	/**
	 * 图片类型的消息处理
	 * 
	 * @param msg
	 * @return
	 */
	public void imageMsg(InMsg msg);

	/**
	 * 视频类型的消息处理
	 * 
	 * @param msg
	 * @return
	 */
	public void videoMsg(InMsg msg);

	/**
	 * 链接类型的消息处理
	 * 
	 * @param msg
	 * @return
	 */
	public void linkMsg(InMsg msg);

	/**
	 * 语音类型的消息处理
	 * 
	 * @param msg
	 * @return
	 */
	public void voiceMsg(InMsg msg);

	/**
	 * 事件类型的消息处理。<br/>
	 * 在用户首次关注公众账号时，系统将会推送一条subscribe的事件
	 * 
	 * @param msg
	 * @return
	 */
	public void eventMsg(InMsg msg);

	/**
	 * 处理流程结束，返回输出信息之前执行
	 */
	public void afterProcess(InMsg inMsg, OutMsg outMsg);

	/**
	 * 设置输出
	 * 
	 * @param outMessage
	 */
	public void setOutMsg(OutMsg outMessage);

	/**
	 * 处返回输出对象
	 */
	public OutMsg getOutMessage();
}
