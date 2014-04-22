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

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

public class MenuButton {
	public static final String TYPE_VIEW = "view";
	public static final String TYPE_CLICK = "click";

	@SuppressWarnings("unchecked")
	Map<String, Object>[] buttonMap = new Map[3];

	/**
	 * 添加一个点击类型的按钮
	 * 
	 * @param index
	 *            按钮的位置，只能输入[1,2,3]
	 * @param name
	 *            按钮所显示的名字
	 * @param key
	 *            点击按钮，发送给公众号的消息体
	 */
	public void addClickButton(int index, String name, String key) {
		if (index > 3 || index < 1) {
			throw new IllegalArgumentException(
					"there is 3 button can create, your input is:" + index);
		}

		if (StringUtils.isBlank(name) || StringUtils.isBlank(key)) {
			throw new NullPointerException("name:" + name + ", key:" + key);
		}

		Map<String, Object> clickButton = new HashMap<String, Object>();
		clickButton.put("type", TYPE_CLICK);
		clickButton.put("name", name);
		clickButton.put("key", key);
		buttonMap[index - 1] = clickButton;
	}

	/**
	 * 添加一个点击类型的按钮
	 * 
	 * @param index
	 *            按钮的位置，只能输入[1,2,3]
	 * @param name
	 *            按钮所显示的名字
	 * @param url
	 *            点击按钮，跳转到相应的链接
	 */
	public void addViewButton(int index, String name, String url) {
		if (index > 3 || index < 1) {
			throw new IllegalArgumentException(
					"there is 3 button can create, your input is:" + index);
		}

		if (StringUtils.isBlank(name) || StringUtils.isBlank(url)) {
			throw new NullPointerException("name:" + name + ", key:" + url);
		}

		Map<String, Object> viewButton = new HashMap<String, Object>();
		viewButton.put("type", TYPE_VIEW);
		viewButton.put("name", name);
		viewButton.put("url", url);
		buttonMap[index - 1] = viewButton;
	}

	/**
	 * 添加自定义的菜单按钮
	 * 
	 * @param index
	 *            菜单的位置，只能输入[1,2,3]
	 * @param name
	 *            菜单所显示的名字
	 * @param subButtons
	 *            多于5个，则只提取前五个菜单
	 */
	@SuppressWarnings("unchecked")
	public void addMenuButton(int index, String name, SubButton... subButtons) {
		if (index > 3 || index < 1) {
			throw new IllegalArgumentException(
					"there is 3 button can create, your input is:" + index);
		}

		if (StringUtils.isBlank(name) || null == subButtons
				|| subButtons.length == 0) {
			throw new NullPointerException("name:" + name + ", subButton:"
					+ subButtons);
		}

		Map<String, Object>[] sb;

		int subBtLenght = subButtons.length;
		if (subBtLenght <= 5) {
			sb = new HashMap[subBtLenght];

			for (int i = 0; i < subBtLenght; i++) {
				sb[i] = subButtons[i].getMap();
			}
		} else {
			sb = new HashMap[5];
			for (int i = 0; i < 5; i++) {
				sb[i] = subButtons[i].getMap();
			}
		}

		Map<String, Object> menuButton = new HashMap<String, Object>();
		menuButton.put("name", name);
		menuButton.put("sub_button", sb);
		buttonMap[index - 1] = menuButton;
	}

	public String toJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("button", buttonMap);
		return JSONObject.fromObject(map).toString();
	}

	public static class SubButton {
		private SubButton() {
			map = new HashMap<String, Object>();
		}

		private Map<String, Object> map;

		public Map<String, Object> getMap() {
			return map;
		}

		/**
		 * 
		 * @param name
		 *            子按钮所显示的名字
		 * @param url
		 *            点击子按钮，跳转到相应的链接
		 * @return
		 */
		public static SubButton createViewSubButton(String name, String url) {
			SubButton button = new SubButton();
			button.map.put("type", TYPE_VIEW);
			button.map.put("name", name);
			button.map.put("url", url);
			return button;
		}

		/**
		 * 添加一个点击类型的按钮
		 * 
		 * @param name
		 *            子按钮所显示的名字
		 * @param key
		 *            子点击按钮，发送给公众号的消息体
		 */
		public static SubButton createClickSubButton(String name, String key) {
			SubButton button = new SubButton();
			button.map.put("type", TYPE_CLICK);
			button.map.put("name", name);
			button.map.put("key", key);
			return button;
		}
	}

	public static void main(String[] args) {
		MenuButton menuButton = new MenuButton();
		menuButton.addClickButton(1, "歌手简介", "V1001_TODAY_SINGER");
		menuButton.addClickButton(2, "今日歌曲", "V1001_TODAY_MUSIC");

		SubButton sb1 = SubButton.createViewSubButton("搜索",
				"http://www.soso.com/");
		SubButton sb2 = SubButton.createViewSubButton("视频", "http://v.qq.com/");
		SubButton sb3 = SubButton.createClickSubButton("赞一下我们0", "V1001_GOOD");
		SubButton sb4 = SubButton.createClickSubButton("赞一下我们1", "V1001_GOOD");
		SubButton sb5 = SubButton.createClickSubButton("赞一下我们2", "V1001_GOOD");
		SubButton sb6 = SubButton.createClickSubButton("赞一下我们3", "V1001_GOOD");

		menuButton.addMenuButton(3, "菜单", new SubButton[] { sb1, sb2, sb3, sb4,
				sb5, sb6 });

		System.out.println(menuButton.toJson());
	}
}
