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
 * 
 * @author Poorzerg
 * @date 2014年4月22日 下午2:05:17
 */
public class FollwersInfo {
	public static class Data {
		private String[] openid;

		public String[] getOpenid() {
			return openid;
		}

		public void setOpenid(String[] openid) {
			this.openid = openid;
		}

		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}
	}

	private long total;
	private long count;
	private Data data;

	private String next_openid;

	public long getCount() {
		return count;
	}

	public Data getData() {
		return data;
	}

	public String getNext_openid() {
		return next_openid;
	}

	public String[] getOpenids() {
		return data.openid;
	}

	public long getTotal() {
		return total;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
