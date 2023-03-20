package com.chinasofti.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单表 order
 *
 * @author huda
 * @date 2019-08-01
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 订单id */
	private String orderId;
	/** 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分 */
	private String payment;
	/** 支付类型，1、在线支付，2、货到付款 */
	private Integer paymentType;
	/** 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分 */
	private String postFee;
	/** 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭 */
	private Integer status;
	/** 创建时间 **/
	private Date createTime;
	/** 更新时间 **/
	private Date updateTime;
	/** 付款时间 */
	private Date paymentTime;
	/** 发货时间 */
	private Date consignTime;
	/** 交易完成时间 */
	private Date endTime;
	/** 交易关闭时间 */
	private Date closeTime;
	/** 物流名称 */
	private String shippingName;
	/** 物流单号 */
	private String shippingCode;
	/** 用户id */
	private Long userId;
	/** 买家留言 */
	private String buyerMessage;
	/** 买家昵称 */
	private String buyerNick;
	/** 买家是否已经评价 */
	private Integer buyerRate;
	/** 商品详情 **/
	private List<Orderproduct> orderproducts;
	/** 物流地址信息 **/
	private Ordershipping ordershipping;

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public String getOrderId()
	{
		return orderId;
	}
	public void setPayment(String payment)
	{
		this.payment = payment;
	}

	public String getPayment()
	{
		return payment;
	}
	public void setPaymentType(Integer paymentType)
	{
		this.paymentType = paymentType;
	}

	public Integer getPaymentType()
	{
		return paymentType;
	}
	public void setPostFee(String postFee)
	{
		this.postFee = postFee;
	}

	public String getPostFee()
	{
		return postFee;
	}
	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Integer getStatus()
	{
		return status;
	}
	public void setPaymentTime(Date paymentTime)
	{
		this.paymentTime = paymentTime;
	}

	public Date getPaymentTime()
	{
		return paymentTime;
	}
	public void setConsignTime(Date consignTime)
	{
		this.consignTime = consignTime;
	}

	public Date getConsignTime()
	{
		return consignTime;
	}
	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	public Date getEndTime()
	{
		return endTime;
	}
	public void setCloseTime(Date closeTime)
	{
		this.closeTime = closeTime;
	}

	public Date getCloseTime()
	{
		return closeTime;
	}
	public void setShippingName(String shippingName)
	{
		this.shippingName = shippingName;
	}

	public String getShippingName()
	{
		return shippingName;
	}
	public void setShippingCode(String shippingCode)
	{
		this.shippingCode = shippingCode;
	}

	public String getShippingCode()
	{
		return shippingCode;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getUserId()
	{
		return userId;
	}
	public void setBuyerMessage(String buyerMessage)
	{
		this.buyerMessage = buyerMessage;
	}

	public String getBuyerMessage()
	{
		return buyerMessage;
	}
	public void setBuyerNick(String buyerNick)
	{
		this.buyerNick = buyerNick;
	}

	public String getBuyerNick()
	{
		return buyerNick;
	}
	public void setBuyerRate(Integer buyerRate)
	{
		this.buyerRate = buyerRate;
	}

	public Integer getBuyerRate()
	{
		return buyerRate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<Orderproduct> getOrderproducts() {
		return orderproducts;
	}

	public void setOrderproducts(List<Orderproduct> orderproducts) {
		this.orderproducts = orderproducts;
	}
	public Ordershipping getOrdershipping() {
		return ordershipping;
	}

	public void setOrdershipping(Ordershipping ordershipping) {
		this.ordershipping = ordershipping;
	}

}
