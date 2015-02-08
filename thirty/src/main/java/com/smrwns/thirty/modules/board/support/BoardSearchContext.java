package com.smrwns.thirty.modules.board.support;

import com.smrwns.thirty.common.web.URLBuilder;
import com.smrwns.thirty.common.web.support.SearchContext;

public class BoardSearchContext extends SearchContext {
	
	private String searchKeyword;
	private String searchType;
	
	
	@Override
	public String getSearchParam() {
		URLBuilder builder = new URLBuilder();
		builder.addParameter("searchKeyword", this.searchKeyword, "");
		builder.addParameter("searchType", this.searchType, "");
		return builder.toString();
	}
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	

}
