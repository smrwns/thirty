package com.smrwns.thirty.common.web.support;

import com.smrwns.thirty.common.web.URLBuilder;

public abstract class SearchContext {
	
	private int p_page = 1;
	private int p_rowsize = 10;
	private int p_totalpage = 10;
	private long p_totalcount;
	private int start_rownum;
	private int end_rownum;
	
	private String o_direction;
	private String o_field;
	
	public void calculateRowNum() {
		this.start_rownum = this.end_rownum - (this.p_rowsize-1);
		this.end_rownum = this.p_page * this.p_rowsize;
		
		this.p_totalpage = (int) Math.ceil((double) p_totalcount/ (double) p_rowsize );
		if(this.p_totalpage == 0) {
			this.p_totalpage = 1;
		}
	}
	
	
	public String getOrderParam() {
		URLBuilder builder = new URLBuilder();
		builder.addParameter("o_direction", this.o_direction, "");
		builder.addParameter("o_field", this.o_field, "");
		return builder.toString();
	}

	public String getPagingParam() {
		URLBuilder builder = new URLBuilder();
		builder.addParameter("p_page", this.p_page, "");
		builder.addParameter("p_rowsize", this.p_rowsize, "");
		builder.addParameter("p_totalpage", this.p_totalpage, "");
		return builder.toString();
	}
	
	public abstract String getSearchParam();
	public String getAllParam(){
		return getSearchParam() +"&"+ getPagingParam() +"&"+ getOrderParam();
	}
	
	
	//get, set
	public int getP_page() {
		return p_page;
	}
	public void setP_page(int p_page) {
		this.p_page = p_page;
	}
	public int getP_rowsize() {
		return p_rowsize;
	}
	public void setP_rowsize(int p_rowsize) {
		this.p_rowsize = p_rowsize;
	}
	public int getP_totalpage() {
		return p_totalpage;
	}
	public void setP_totalpage(int p_totalpage) {
		this.p_totalpage = p_totalpage;
	}
	public long getP_totalcount() {
		return p_totalcount;
	}
	public void setP_totalcount(long p_totalcount) {
		this.p_totalcount = p_totalcount;
	}
	public int getStart_rownum() {
		return start_rownum;
	}
	public void setStart_rownum(int start_rownum) {
		this.start_rownum = start_rownum;
	}
	public int getEnd_rownum() {
		return end_rownum;
	}
	public void setEnd_rownum(int end_rownum) {
		this.end_rownum = end_rownum;
	}
	public String getO_direction() {
		return o_direction;
	}
	public void setO_direction(String o_direction) {
		this.o_direction = o_direction;
	}
	public String getO_field() {
		return o_field;
	}
	public void setO_field(String o_field) {
		this.o_field = o_field;
	}
}
