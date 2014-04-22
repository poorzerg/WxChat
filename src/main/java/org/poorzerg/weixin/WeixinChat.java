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
package org.poorzerg.weixin;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.poorzerg.weixin.bean.msg.InMsg;
import org.poorzerg.weixin.bean.msg.out.OutMsg;
import org.poorzerg.weixin.conn.AccessTokenConn;
import org.poorzerg.weixin.conn.GroupConn;
import org.poorzerg.weixin.conn.MediaConn;
import org.poorzerg.weixin.conn.MenuConn;
import org.poorzerg.weixin.conn.MessageConn;
import org.poorzerg.weixin.conn.UserConn;
import org.poorzerg.weixin.process.DefaultMsgProcess;
import org.poorzerg.weixin.process.MsgProcess;
import org.poorzerg.weixin.utils.SHA1;
import org.poorzerg.weixin.utils.XStreamFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;

public class WeixinChat {
	private static final Logger LOG = LoggerFactory.getLogger(WeixinChat.class);

	private static MsgProcess msgProcess = new DefaultMsgProcess();

	public static final AccessTokenConn accessToken = new AccessTokenConn();
	/** 消息操作接口 */
	public static final MessageConn message = new MessageConn();
	/** 菜单操作接口 */
	public static final MenuConn menu = new MenuConn();
	/** 用户操作接口 */
	public static final UserConn user = new UserConn();
	/** 分组操作接口 */
	public static final GroupConn group = new GroupConn();
	/** 媒体文件操作接口 */
	public static final MediaConn media = new MediaConn();

	/**
	 * 分流注册处理器
	 * 
	 * @param msgProcess
	 */

	public static void setMsgProcess(MsgProcess msgProcess) {
		WeixinChat.msgProcess = msgProcess;
	}

	/**
	 * 签名检查
	 * 
	 * @param token
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static Boolean checkSignature(String token, String signature,
			String timestamp, String nonce) {
		List<String> params = new ArrayList<String>();
		params.add(token);
		params.add(timestamp);
		params.add(nonce);
		Collections.sort(params, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		String temp = params.get(0) + params.get(1) + params.get(2);
		return SHA1.encode(temp).equals(signature);
	}

	/**
	 * 根据接收到用户消息进行处理
	 * 
	 * @param inMsgXml
	 *            微信发送过来的xml消息体
	 * @return
	 */
	public static String processing(String inMsgXml) {
		InMsg inMessage = parsingInMessage(inMsgXml);

		OutMsg oms = null;
		String xml = "";

		try {
			msgProcess.allType(inMessage);
			String type = inMessage.getMsgType();
			Method method = msgProcess.getClass().getMethod(type + "Msg",
					InMsg.class);

			if (method != null) {
				method.invoke(msgProcess, inMessage);
				oms = msgProcess.getOutMessage();
				if (null != oms) {
					setMsgInfo(oms, inMessage);
					msgProcess.afterProcess(inMessage, oms);
					xml = oms.toXml();
				}
			}
		} catch (Exception e) {
			LOG.error("process the msg error! inMsg:[" + inMessage.toString()
					+ "]", e);
		}
		return xml;
	}

	/**
	 * 设置发送消息体
	 * 
	 * @param oms
	 * @param msg
	 * @throws Exception
	 */
	private static void setMsgInfo(OutMsg oms, InMsg msg) throws Exception {
		if (oms != null) {
			Class<?> outMsg = oms.getClass().getSuperclass();
			Field CreateTime = outMsg.getDeclaredField("CreateTime");
			Field ToUserName = outMsg.getDeclaredField("ToUserName");
			Field FromUserName = outMsg.getDeclaredField("FromUserName");

			ToUserName.setAccessible(true);
			CreateTime.setAccessible(true);
			FromUserName.setAccessible(true);

			CreateTime.set(oms, new Date().getTime());
			ToUserName.set(oms, msg.getFromUserName());
			FromUserName.set(oms, msg.getToUserName());
		}
	}

	/**
	 * 将腾讯推送过来的xml内容解析为实体类{@link InMsg}
	 * 
	 * @param inMsgXml
	 * @return
	 */
	private static InMsg parsingInMessage(String inMsgXml) {
		XStream xs = XStreamFactory.init(false);
		xs.ignoreUnknownElements();
		xs.autodetectAnnotations(true);
		return (InMsg) xs.fromXML(inMsgXml);
	}

}
