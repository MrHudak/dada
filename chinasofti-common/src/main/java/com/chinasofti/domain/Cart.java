package com.chinasofti.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 购物车表 cart
 *
 * @author huda
 * @date 2019-08-01
 */
public class Cart implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 自增ID */
	private Long id;
	/** 用户ID */
	private Long userId;
	/** 商品ID */
	private Long productId;
	/** 商品标题 */
	private String productTitle;
	/** 商品主图 */
	private String productImage;
	/** 商品价格，单位为：分 */
	private Long productPrice;
	/** 购买数量 */
	private Integer num;
	/**  */
	private Date created;
	/**  */
	private Date updated;

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getUserId()
	{
		return userId;
	}
	public void setProductId(Long productId)
	{
		this.productId = productId;
	}

	public Long getProductId()
	{
		return productId;
	}
	public void setProductTitle(String productTitle)
	{
		this.productTitle = productTitle;
	}

	public String getProductTitle()
	{
		return productTitle;
	}
	public void setProductImage(String productImage)
	{
		this.productImage = productImage;
	}

	public String getProductImage()
	{
		return productImage;
	}
	public void setProductPrice(Long productPrice)
	{
		this.productPrice = productPrice;
	}

	public Long getProductPrice()
	{
		return productPrice;
	}
	public void setNum(Integer num)
	{
		this.num = num;
	}

	public Integer getNum()
	{
		return num;
	}
	public void setCreated(Date created)
	{
		this.created = created;
	}

	public Date getCreated()
	{
		return created;
	}
	public void setUpdated(Date updated)
	{
		this.updated = updated;
	}

	public Date getUpdated()
	{
		return updated;
	}

}
