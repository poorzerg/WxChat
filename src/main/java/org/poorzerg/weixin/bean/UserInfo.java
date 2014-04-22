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

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * 用戶实体
 * 
 * @author ZLong
 * 
 */
public class UserInfo {
	/**
	 * 用户是否订阅该公众号标识<br>
	 * 值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 */
	private int subscribe;
	private String openid;
	private String nickname;

	/** 0=未知，1=男性，2=女性 */
	private int sex;
	private String city;
	private String country;
	private String province;
	private String language;
	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像)<br>
	 * 用户没有头像时该项为空
	 */
	private String headimgurl;
	private Long subscribe_time;

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	/**
	 * 返回46*46的头像url
	 * 
	 * @return
	 */
	public String getHeadimgurl_46() {
		return headimgurl.substring(0, headimgurl.length() - 1) + 46;
	}

	/**
	 * 返回64*64的头像url
	 * 
	 * @return
	 */
	public String getHeadimgurl_64() {
		return headimgurl.substring(0, headimgurl.length() - 1) + 64;
	}

	/**
	 * 返回96*96的头像url
	 * 
	 * @return
	 */
	public String getHeadimgurl_96() {
		return headimgurl.substring(0, headimgurl.length() - 1) + 96;
	}

	/**
	 * 返回132*132的头像url
	 * 
	 * @return
	 */
	public String getHeadimgurl_132() {
		return headimgurl.substring(0, headimgurl.length() - 1) + 132;
	}

	/**
	 * 返回640*640的头像url
	 * 
	 * @return
	 */
	public String getHeadimgurl_640() {
		return headimgurl;
	}

	public String getLanguage() {
		return language;
	}

	public String getNickname() {
		return nickname;
	}

	public String getOpenid() {
		return openid;
	}

	public String getProvince() {
		return province;
	}

	public int getSex() {
		return sex;
	}

	public int getSubscribe() {
		return subscribe;
	}

	public Long getSubscribe_time() {
		return subscribe_time;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}

	public void setSubscribe_time(Long subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
