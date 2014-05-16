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

import java.io.BufferedInputStream;

import org.poorzerg.weixin.bean.msg.ErrCodeMsg;

public class Attachment {
	private String fileName;
	private String fullName;
	private String suffix;
	private String contentLength;
	private String contentType;
	private BufferedInputStream fileStream;
	private ErrCodeMsg errCode;

	public String getContentLength() {
		return contentLength;
	}

	public String getContentType() {
		return contentType;
	}

	public ErrCodeMsg getErrCode() {
		return errCode;
	}

	public String getFileName() {
		return fileName;
	}

	public BufferedInputStream getFileStream() {
		return fileStream;
	}

	public String getFullName() {
		return fullName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setErrCode(ErrCodeMsg errCode) {
		this.errCode = errCode;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileStream(BufferedInputStream fileStream) {
		this.fileStream = fileStream;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
