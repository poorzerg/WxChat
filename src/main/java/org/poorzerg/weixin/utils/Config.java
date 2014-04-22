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
package org.poorzerg.weixin.utils;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置读取
 * 
 * @author ZLong
 * 
 */
public class Config {
	private static final Logger LOG = LoggerFactory.getLogger(Config.class);
	private static Properties props = new Properties();

	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("config.properties"));
		} catch (Exception e) {
			LOG.error(
					"can`t read the config file properly, the system will exit!",
					e);
			System.exit(-1);
		}
	}

	public static String getString(String key) {
		return props.getProperty(key);
	}

	public static String getString(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}

	public static void main(String[] args) {
		System.out.println(getString("appid"));
	}
}
