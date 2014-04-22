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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 输出图文消息
 * 
 */
@XStreamAlias("xml")
public class NewsOutMsg extends OutMsg {
	public static class Article implements Serializable {
		private static final long serialVersionUID = -1689261756200677907L;
		private String Title;
		private String Description;
		private String PicUrl;
		private String Url;

		public Article() {
		}

		public Article(String title, String description, String pirUrl,
				String url) {
			this.Title = title;
			this.Description = description;
			this.PicUrl = pirUrl;
			this.Url = url;
		}

		public String getDescription() {
			return Description;
		}

		public String getPicUrl() {
			return PicUrl;
		}

		public String getTitle() {
			return Title;
		}

		public String getUrl() {
			return Url;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public void setPicUrl(String picUrl) {
			PicUrl = picUrl;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public void setUrl(String url) {
			Url = url;
		}
	}

	private Integer ArticleCount;
	private String Title;
	private String Description;

	private String PicUrl;

	private String Url;

	@XStreamImplicit(itemFieldName = "item")
	private List<Article> Articles = new ArrayList<Article>();

	public NewsOutMsg() {
		super("news");
	}

	public void addArticle(String title, String description, String pirUrl,
			String url) {
		Articles.add(new Article(title, description, pirUrl, url));
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public String getDescription() {
		return Description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public String getTitle() {
		return Title;
	}

	public String getUrl() {
		return Url;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public static void main(String[] args) {

		NewsOutMsg out = new NewsOutMsg();
		out.setDescription("描述");
		out.setPicUrl("pictrue:url");
		out.setTitle("titlle");
		out.setUrl("http:url");

		out.addArticle("a:tittle", "a:description", "pic+url", "a:url");
		out.addArticle("a:tittle1", "a:description1", "pic+url1", "a:url1");

		System.out.println(out.toXml());
	}
}
