package com.chinasofti.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单物流表 ordershipping
 *
 * @author huda
 * @date 2019-08-01
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ordershipping implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 订单ID */
	private String orderId;
	/** 收货人全名 */
	private String receiverName;
	/** 固定电话 */
	private String receiverPhone;
	/** 移动电话 */
	private String receiverMobile;
	/** 省份 */
	private String receiverState;
	/** 城市 */
	private String receiverCity;
	/** 区/县 */
	private String receiverDistrict;
	/** 收货地址，如：xx路xx号 */
	private String receiverAddress;
	/** 邮政编码,如：510001 */
	private String receiverZip;
	/**  */
	private Date created;
	/**  */
	private Date updated;

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public String getOrderId()
	{
		return orderId;
	}
	public void setReceiverName(String receiverName)
	{
		this.receiverName = receiverName;
	}

	public String getReceiverName()
	{
		return receiverName;
	}
	public void setReceiverPhone(String receiverPhone)
	{
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverPhone()
	{
		return receiverPhone;
	}
	public void setReceiverMobile(String receiverMobile)
	{
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverMobile()
	{
		return receiverMobile;
	}
	public void setReceiverState(String receiverState)
	{
		this.receiverState = receiverState;
	}

	public String getReceiverState()
	{
		return receiverState;
	}
	public void setReceiverCity(String receiverCity)
	{
		this.receiverCity = receiverCity;
	}

	public String getReceiverCity()
	{
		return receiverCity;
	}
	public void setReceiverDistrict(String receiverDistrict)
	{
		this.receiverDistrict = receiverDistrict;
	}

	public String getReceiverDistrict()
	{
		return receiverDistrict;
	}
	public void setReceiverAddress(String receiverAddress)
	{
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverAddress()
	{
		return receiverAddress;
	}
	public void setReceiverZip(String receiverZip)
	{
		this.receiverZip = receiverZip;
	}

	public String getReceiverZip()
	{
		return receiverZip;
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
