package com.chinasofti.domain;

import java.io.Serializable;
import java.util.List;

public class SolrResult implements Serializable{

	//当前页
	private Integer curPage;

	//总页数
	private Integer pageCount;

	//数据的总条数
	private Long recordCount;

	//商品结果集
	private List<?> productList;

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public List<?> getProductList() {
		return productList;
	}

	public void setProductList(List<?> productList) {
		this.productList = productList;
	}

	public SolrResult(Integer curPage, Integer pageCount, Long recordCount,
			List<?> productList) {
		super();
		this.curPage = curPage;
		this.pageCount = pageCount;
		this.recordCount = recordCount;
		this.productList = productList;
	}

	public SolrResult() {
		super();
	}


}
