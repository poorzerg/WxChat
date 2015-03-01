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
package org.poorzerg.weixin.type;

/**
 * 
 * @author Poorzerg 创建时间：2014年4月22日 下午12:06:15
 */
public enum MediaType {

	/** 图片（image）: 128K，支持JPG格式 */
	IMAGE("image"),
	/** 语音（voice）：256K，播放长度不超过60s，支持AMR\MP3格式 */
	VOICE("voice"),
	/** 视频（video）：1MB，支持MP4格式 */
	VIDEO("video"),
	/** 缩略图（thumb）：64KB，支持JPG格式 */
	THUMB("thumb");

	private String value;

	private MediaType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
