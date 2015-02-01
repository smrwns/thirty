package com.smrwns.thirty.modules.board.support;

import com.smrwns.thirty.common.web.URLBuilder;
import com.smrwns.thirty.common.web.support.SearchContext;

public class BoardSearchContext extends SearchContext {
	
	private String s_keyword;
	private String s_search_type;
	
	
	@Override
	public String getSearchParam() {
		URLBuilder builder = new URLBuilder();
		builder.addParameter("s_keyword", this.s_keyword, "");
		builder.addParameter("s_search_type", this.s_search_type, "");
		return builder.toString();
	}
	
	public String getS_keyword() {
		return s_keyword;
	}
	public void setS_keyword(String s_keyword) {
		this.s_keyword = s_keyword;
	}
	public String getS_search_type() {
		return s_search_type;
	}
	public void setS_search_type(String s_search_type) {
		this.s_search_type = s_search_type;
	}
	

}
