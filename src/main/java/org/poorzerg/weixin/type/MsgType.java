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

public enum MsgType {
	TEXT("text"), //
	IMAGE("image"), //
	VOICE("voice"), //
	VIDEO("video"), //
	NEWS("news"), //
	MUSIC("music"), //
	LINK("link"), //
	LOCATION("location"), //
	EVENT("event");

	private String name;

	private MsgType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
