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

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.poorzerg.weixin.utils.Config;

/**
 * 
 * @author Poorzerg
 * @date 2014年4月22日 下午4:53:10
 */
public class WxMsgCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = -3440013782239473203L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 微信加密签名
		String signature = req.getParameter("signature");
		// 时间戳
		String timestamp = req.getParameter("timestamp");
		// 随机数
		String nonce = req.getParameter("nonce");
		// 随机字符串
		String echostr = req.getParameter("echostr");

		if (StringUtils.isNotBlank(signature)
				&& StringUtils.isNotBlank(timestamp)
				&& StringUtils.isNotBlank(nonce)
				&& StringUtils.isNotBlank(echostr)) {
			String token = Config.getString("tokenkey");

			PrintWriter out = resp.getWriter();
			if (WeixinChat.checkSignature(token, signature, timestamp, nonce)) {
				out.print(echostr);
			}
			out.close();
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String returnXml = "";

		ServletInputStream in = req.getInputStream();
		if (in != null) {

			StringBuffer out = new StringBuffer();
			byte[] b = new byte[4096];
			for (int n; (n = in.read(b)) != -1;) {
				out.append(new String(b, 0, n, "utf-8"));
			}

			String xmlMsg = out.toString();
			returnXml = WeixinChat.processing(xmlMsg);
		}

		// 返回响应消息
		PrintWriter out = resp.getWriter();
		out.print(returnXml);
		out.close();
	}
}
