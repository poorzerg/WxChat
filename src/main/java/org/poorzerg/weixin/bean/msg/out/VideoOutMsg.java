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

import org.poorzerg.weixin.utils.XStreamFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 输出视频消息
 * 
 */
@XStreamAlias("xml")
public class VideoOutMsg extends OutMsg {
	public static class Video {
		private String MediaId;
		private String Title;
		private String Description;

		public String getDescription() {
			return Description;
		}

		public String getMediaId() {
			return MediaId;
		}

		public String getTitle() {
			return Title;
		}

	}

	private Video Video = new Video();

	protected VideoOutMsg() {
		super("video");
	}

	public Video getVideo() {
		return Video;
	}

	public void setDescription(String description) {
		Video.Description = description;
	}

	public void setMediaId(String mediaId) {
		Video.MediaId = mediaId;
	}

	public void setTitle(String title) {
		Video.Title = title;
	}

	public static void main(String[] args) {
		VideoOutMsg out = new VideoOutMsg();
		out.setMediaId("ceshiid");
		out.setTitle("title");
		out.setDescription("des");

		XStream xs = XStreamFactory.init(true);
		xs.alias("xml", out.getClass());
		String xml = xs.toXML(out);
		System.out.println(xml);
	}

}
