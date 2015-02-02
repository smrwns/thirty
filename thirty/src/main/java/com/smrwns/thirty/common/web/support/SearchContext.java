package com.smrwns.thirty.common.web.support;

import com.smrwns.thirty.common.web.URLBuilder;

public abstract class SearchContext {
	
	private int nowPage = 1;
	private int rowCountPerPage = 10;
	private int pageCountPerPage = 10;
	private int totalPageCount;
	private long totalRowCount;
	
	private int start_rownum;
	private int end_rownum;
	
	private String order_direction;
	private String order_field;
	
	public void calculateRowNum() {
		this.end_rownum = this.nowPage * this.rowCountPerPage;
		this.start_rownum = this.end_rownum - (this.rowCountPerPage-1);
		
		this.totalPageCount = (int) Math.ceil((double) totalRowCount/ (double) rowCountPerPage );
		if(this.totalPageCount == 0) {
			this.totalPageCount = 1;
		}
	}
	
	public String getOrderParam() {
		URLBuilder builder = new URLBuilder();
		builder.addParameter("order_direction", this.order_direction, "");
		builder.addParameter("order_field", this.order_field, "");
		return builder.toString();
	}

	public String getPagingParam() {
		URLBuilder builder = new URLBuilder();
		builder.addParameter("nowPage", this.nowPage, "");
		builder.addParameter("rowCountPerPage", this.rowCountPerPage, "");
		builder.addParameter("totalPageCount", this.totalPageCount, "");
		return builder.toString();
	}
	
	public abstract String getSearchParam();
	public String getAllParam(){
		return getSearchParam() +"&"+ getPagingParam() +"&"+ getOrderParam();
	}

	
	//getter, setter
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getRowCountPerPage() {
		return rowCountPerPage;
	}

	public void setRowCountPerPage(int rowCountPerPage) {
		this.rowCountPerPage = rowCountPerPage;
	}

	public int getPageCountPerPage() {
		return pageCountPerPage;
	}

	public void setPageCountPerPage(int pageCountPerPage) {
		this.pageCountPerPage = pageCountPerPage;
	}

	public long getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(long totalRowCount) {
		this.totalRowCount = totalRowCount;
		this.calculateRowNum();
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

	public String getOrder_direction() {
		return order_direction;
	}

	public void setOrder_direction(String order_direction) {
		this.order_direction = order_direction;
	}

	public String getOrder_field() {
		return order_field;
	}

	public void setOrder_field(String order_field) {
		this.order_field = order_field;
	}
	
}
