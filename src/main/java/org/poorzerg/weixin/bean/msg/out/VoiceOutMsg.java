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
 * 输出语音消息
 * 
 */
@XStreamAlias("xml")
public class VoiceOutMsg extends OutMsg {
	public static class Voice {
		private String MediaId;

		public String getMediaId() {
			return MediaId;
		}
	}

	private Voice Voice = new Voice();

	public VoiceOutMsg() {
		super("voice");
	}

	public Voice getVoice() {
		return Voice;
	}

	public void setMediaId(String mediaId) {
		Voice.MediaId = mediaId;
	}

	public static void main(String[] args) {
		VoiceOutMsg out = new VoiceOutMsg();
		out.setMediaId("ceshiid");
		System.out.println(out.toXml());
	}
}
