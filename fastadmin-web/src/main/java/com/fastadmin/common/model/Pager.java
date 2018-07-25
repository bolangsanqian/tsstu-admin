package com.fastadmin.common.model;

public class Pager {
	
	// 查询页数
	private Integer pageNum = 1;

	// 每页数量
	private Integer pageSize = 10;

	// 排序
	private String orderBy = "";

	public Integer getPageNum() {
		return pageNum == null ? 1 : pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize == null ? 1 : pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
}