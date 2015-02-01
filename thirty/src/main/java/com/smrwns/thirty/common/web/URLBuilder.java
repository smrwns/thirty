package com.smrwns.thirty.common.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.smrwns.thirty.common.util.ValidationUtils;

public class URLBuilder {
	private StringBuilder builder;
	private String encoding;
	
	public URLBuilder() {
		builder = new StringBuilder();
		this.encoding = "EUC-KR";
	}
	
	
	public void addParameter(String parameterName, Object value, String defaultValue) {
		StringBuilder localBuilder = makeForeHead(parameterName);
		if(ValidationUtils.isNotNull(value))
			localBuilder.append(encode(String.valueOf(value)));
		else if(ValidationUtils.isNotNull(defaultValue))
			localBuilder.append(encode(String.valueOf(defaultValue)));
		else
			return;
		builder.append(localBuilder.toString());
	}
	
	
	private StringBuilder makeForeHead(String parameterName) {
		StringBuilder localBuilder = new StringBuilder();
		if(builder.length() > 0) {
			localBuilder.append("&");
		}
		localBuilder.append(parameterName);
		localBuilder.append("=");
		return localBuilder;
	}
	
	
	private String encode(String string) {
		try {
			return URLEncoder.encode(string, encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getEncoding() {
		return this.encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	@Override
	public String toString() {
		return builder.toString();
	}
}
	
