/**
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
package org.poorzerg.weixin.bean.msg.out;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 输出文字消息
 * 
 */
@XStreamAlias("xml")
public class TextOutMsg extends OutMsg {
	private String Content;

	public TextOutMsg() {
		super("text");
	}

	public TextOutMsg(String content) {
		super("text");
		Content = content;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public static void main(String[] args) {
		TextOutMsg text = new TextOutMsg("你好");
		System.out.println(text.toXml());
	}
}
