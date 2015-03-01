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

import org.poorzerg.weixin.bean.msg.in.InMsg;
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
	 * @param in
	 * @param out
	 * @return
	 */
	public OutMsg textMsg(InMsg in);

	/**
	 * 地理位置类型的消息处理
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	public OutMsg locationMsg(InMsg in);

	/**
	 * 图片类型的消息处理
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	public OutMsg imageMsg(InMsg in);

	/**
	 * 视频类型的消息处理
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	public OutMsg videoMsg(InMsg in);

	/**
	 * 链接类型的消息处理
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	public OutMsg linkMsg(InMsg in);

	/**
	 * 语音类型的消息处理
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	public OutMsg voiceMsg(InMsg in);

	/**
	 * 事件类型的消息处理。<br/>
	 * 在用户首次关注公众账号时，系统将会推送一条subscribe的事件
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	public OutMsg eventMsg(InMsg in);

	/**
	 * 处理流程结束，返回输出信息之前执行
	 * 
	 * @param inMsg
	 * @param outMsg
	 */
	public OutMsg afterProcess(InMsg inMsg, OutMsg outMsg);
}
