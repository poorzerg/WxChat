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
package org.poorzerg.weixin.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * 
 * @author Poorzerg
 * @date 2014年4月23日 下午2:21:27
 */

public class Menu {
	public static final String TYPE_VIEW = "view";
	public static final String TYPE_CLICK = "click";

	private List<Button> button = new ArrayList<Button>(3);

	public Menu() {
	}

	public List<Button> getButton() {
		return button;
	}

	public void setButton(List<Button> button) {
		this.button = button;
	}

	/**
	 * 添加一个点击类型的按钮，多于3个时只提取前3个
	 * 
	 * @param name
	 *            按钮所显示的名字
	 * @param url
	 *            点击按钮，跳转到相应的链接
	 */
	public void addViewButton(String name, String url) {
		if (button.size() >= 3) {
			return;
		}

		if (StringUtils.isBlank(name) || StringUtils.isBlank(url)) {
			throw new NullPointerException("name:" + name + ", key:" + url);
		}

		Button b = new Button();
		b.setType(TYPE_VIEW);
		b.setName(name);
		b.setUrl(url);
		button.add(b);
	}

	/**
	 * 添加一个点击类型的按钮，多于3个时只提取前3个
	 * 
	 * @param name
	 *            按钮所显示的名字
	 * @param key
	 *            点击按钮，发送给公众号的消息体
	 */
	public void addClickButton(String name, String key) {
		if (button.size() >= 3) {
			return;
		}

		if (StringUtils.isBlank(name) || StringUtils.isBlank(key)) {
			throw new NullPointerException("name:" + name + ", key:" + key);
		}

		Button b = new Button();
		b.setType(TYPE_CLICK);
		b.setName(name);
		b.setKey(key);

		button.add(b);
	}

	/**
	 * 添加自定义的菜单按钮
	 * 
	 * @param name
	 *            菜单所显示的名字
	 * @param subButtons
	 *            多于5个，则只提取前五个菜单
	 */
	public void addMenuButton(String name, SubButton... subButtons) {
		if (button.size() >= 3) {
			return;
		}

		if (StringUtils.isBlank(name) || null == subButtons) {
			throw new NullPointerException("name:" + name + ", subButton:"
					+ subButtons);
		}

		if (subButtons.length <= 0 || subButtons.length > 5) {
			throw new IllegalArgumentException(
					"ths subButton size should be 0<size<=5, input is:"
							+ subButtons.length);
		}

		Button b = new Button();
		b.setName(name);
		b.setSub_button(Arrays.asList(subButtons));

		button.add(b);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String toJson() {
		JsonConfig jcToJson = new JsonConfig();
		jcToJson.setJsonPropertyFilter(new PropertyFilter() {

			@Override
			public boolean apply(Object obj, String name, Object value) {

				if (value == null) {
					return true;
				}

				if (name.equalsIgnoreCase("sub_button")) {
					if (value instanceof List)
						if (((List<?>) value).size() == 0) {
							return true;
						}
				}

				return false;
			}
		});

		return JSONObject.fromObject(this, jcToJson).toString();
	}

	public static Menu createFromJson(String json) {
		JsonConfig jcToBean = new JsonConfig();
		jcToBean.setJsonPropertyFilter(new PropertyFilter() {

			@Override
			public boolean apply(Object obj, String name, Object value) {

				if (value == null) {
					return true;
				}

				if (name.equalsIgnoreCase("sub_button")) {
					if (value instanceof JSONArray)
						if (((JSONArray) value).toString().equalsIgnoreCase(
								"[]")) {
							return true;
						}
				}

				return false;
			}
		});

		return (Menu) JSONObject.toBean(JSONObject.fromObject(json, jcToBean),
				Menu.class);
	}

	public static class Button {

		private String type;
		private String name;
		private String key;
		private String url;
		private List<SubButton> sub_button = new ArrayList<SubButton>(5);

		public Button() {
		}

		public List<SubButton> getSub_button() {
			return sub_button;
		}

		public void setSub_button(List<SubButton> sub_button) {
			this.sub_button = sub_button;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}
	}

	public static class SubButton {
		private String type;
		private String name;
		private String key;
		private String url;

		public static SubButton createViewSubButton(String name, String url) {
			if (StringUtils.isBlank(name) || StringUtils.isBlank(url)) {
				throw new NullPointerException("name:" + name + ", key:" + url);
			}
			SubButton sb = new SubButton();
			sb.setType(TYPE_VIEW);
			sb.setName(name);
			sb.setUrl(url);
			return sb;
		}

		public static SubButton createClickSubButton(String name, String key) {
			if (StringUtils.isBlank(name) || StringUtils.isBlank(key)) {
				throw new NullPointerException("name:" + name + ", key:" + key);
			}
			SubButton sb = new SubButton();
			sb.setType(TYPE_CLICK);
			sb.setName(name);
			sb.setKey(key);
			return sb;
		}

		public SubButton() {
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}
	}
}
