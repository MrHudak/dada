package com.chinasofti.domain;

import java.io.Serializable;

/**
 * 商品描述表 productdesc
 *
 * @author huda
 * @date 2019-08-01
 */
public class Productdesc implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 商品ID */
	private Long id;
	/** 商品描述 */
	private String productdesc;

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}
	public void setProductdesc(String productdesc)
	{
		this.productdesc = productdesc;
	}

	public String getProductdesc()
	{
		return productdesc;
	}

}
