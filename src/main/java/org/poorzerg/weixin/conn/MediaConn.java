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
package org.poorzerg.weixin.conn;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.poorzerg.weixin.bean.AccessToken;
import org.poorzerg.weixin.bean.MediaInfo;
import org.poorzerg.weixin.bean.msg.ErrCodeMsg;
import org.poorzerg.weixin.utils.Attachment;
import org.poorzerg.weixin.utils.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediaConn {
	private static final Logger LOG = LoggerFactory.getLogger(MediaConn.class);

	private static final String GET_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=";
	private static final String UPLOAD_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=";

	/**
	 * 获取媒体资源
	 * 
	 * @param accessToken
	 * @param mediaId
	 * @return
	 * @throws IOException
	 */
	public Attachment getMedia(AccessToken accessToken, String mediaId)
			throws IOException {
		String url = GET_MEDIA_URL + accessToken.getAccessToken()
				+ "&media_id=" + mediaId;
		return Http.download(url);
	}

	/**
	 * 上传素材文件
	 * 
	 * @param accessToken
	 * @param type
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public MediaInfo uploadMedia(AccessToken accessToken, String type, File file)
			throws Exception {
		String url = UPLOAD_MEDIA_URL + accessToken.getAccessToken() + "&type="
				+ type;
		String result = Http.upload(url, file);
		if (StringUtils.isNotBlank(result)) {
			JSONObject obj = JSONObject.fromObject(result);
			if (null != obj.get("errcode")) {
				ErrCodeMsg eCode = new ErrCodeMsg(obj);
				LOG.error(
						"upload the media error! type:[{}], filePath:[{}], errMsg:[{}]",
						type, file.getAbsolutePath(), eCode.toString());
				return null;
			}
			return (MediaInfo) JSONObject.toBean(obj, MediaInfo.class);
		}
		return null;
	}

}
