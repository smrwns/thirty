package com.smrwns.thirty.common.web.support;

import com.smrwns.thirty.common.web.URLBuilder;

public abstract class SearchContext {
	
	private int numPage = 1;
	private int rowCountPerPage = 10;
	private int pageCountPerPage = 10;
	private int totalPageCount;
	private long totalRowCount;
	
	private int startRownum;
	private int endRownum;
	
	private String orderDirection;
	private String orderField;
	
	public void calculateRowNum() {
		this.endRownum = this.numPage * this.rowCountPerPage;
		this.startRownum = this.endRownum - (this.rowCountPerPage-1);
		
		this.totalPageCount = (int) Math.ceil((double) totalRowCount/ (double) rowCountPerPage );
		if(this.totalPageCount == 0) {
			this.totalPageCount = 1;
		}
	}
	
	public String getOrderParam() {
		URLBuilder builder = new URLBuilder();
		builder.addParameter("orderDirection", this.orderDirection, "");
		builder.addParameter("orderField", this.orderField, "");
		return builder.toString();
	}

	public String getPagingParam() {
		URLBuilder builder = new URLBuilder();
		builder.addParameter("numPage", this.numPage, "");
		builder.addParameter("rowCountPerPage", this.rowCountPerPage, "");
		builder.addParameter("totalPageCount", this.totalPageCount, "");
		return builder.toString();
	}
	
	public abstract String getSearchParam();
	public String getAllParam(){
		return getSearchParam() +"&"+ getPagingParam() +"&"+ getOrderParam();
	}

	public int getNumPage() {
		return numPage;
	}

	public void setNumPage(int numPage) {
		this.numPage = numPage;
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

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public long getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(long totalRowCount) {
		this.totalRowCount = totalRowCount;
		this.calculateRowNum();
	}

	public int getStartRownum() {
		return startRownum;
	}

	public void setStartRownum(int startRownum) {
		this.startRownum = startRownum;
	}

	public int getEndRownum() {
		return endRownum;
	}

	public void setEndRownum(int endRownum) {
		this.endRownum = endRownum;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
}
