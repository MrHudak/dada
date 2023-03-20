package com.chinasofti.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 订单详情表 orderproduct
 *
 * @author huda
 * @date 2019-08-01
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Orderproduct implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 商品id */
	private String productId;
	/** 订单id */
	private String orderId;
	/** 商品购买数量 */
	private Integer num;
	/** 商品标题 */
	private String title;
	/** 商品单价 */
	private Long price;
	/** 商品总金额 */
	private Long totalFee;
	/** 商品图片地址 */
	private String imagePath;




	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public String getProductId()
	{
		return productId;
	}
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public String getOrderId()
	{
		return orderId;
	}
	public void setNum(Integer num)
	{
		this.num = num;
	}

	public Integer getNum()
	{
		return num;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}
	public void setPrice(Long price)
	{
		this.price = price;
	}

	public Long getPrice()
	{
		return price;
	}
	public void setTotalFee(Long totalFee)
	{
		this.totalFee = totalFee;
	}

	public Long getTotalFee()
	{
		return totalFee;
	}
	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}

	public String getImagePath()
	{
		return imagePath;
	}

}
