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
package org.poorzerg.weixin.bean.msg.out;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 输出音乐消息
 * 
 * @author Poorzerg
 * 
 */
@XStreamAlias("xml")
public class MusicOutMsg extends OutMsg {
	public static class Music {
		private String Title;
		private String Description;
		private String MusicUrl;
		private String HQMusicUrl;
		private String ThumbMediaId;

		public String getDescription() {
			return Description;
		}

		public String getHQMusicUrl() {
			return HQMusicUrl;
		}

		public String getMusicUrl() {
			return MusicUrl;
		}

		public String getThumbMediaId() {
			return ThumbMediaId;
		}

		public String getTitle() {
			return Title;
		}
	}

	private Music Music = new Music();

	public MusicOutMsg() {
		super("music");
	}

	public Music getMusic() {
		return Music;
	}

	public void setDescription(String description) {
		Music.Description = description;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		Music.HQMusicUrl = hQMusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		Music.MusicUrl = musicUrl;
	}

	public void setThumbMediaId(String thumbMediaId) {
		Music.ThumbMediaId = thumbMediaId;
	}

	public void setTitle(String title) {
		Music.Title = title;
	}

	public static void main(String[] args) {
		MusicOutMsg out = new MusicOutMsg();
		out.setTitle("tittle");
		out.setDescription("escription");
		out.setHQMusicUrl("hQMusicUrl");
		out.setMusicUrl("musicUrl");
		out.setThumbMediaId("thumbMediaId");

		System.out.println(out.toXml());
	}
}
