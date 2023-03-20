package com.chinasofti.mapper;

import com.chinasofti.domain.Ordershipping;

import java.util.List;

/**
 * 订单物流 数据层
 *
 * @author huda
 * @date 2019-08-01
 */
public interface OrdershippingMapper
{
	/**
     * 查询订单物流信息
     *
     * @param orderId 订单物流ID
     * @return 订单物流信息
     */
	public Ordershipping selectOrdershippingById(String orderId);

	/**
     * 查询订单物流列表
     *
     * @param ordershipping 订单物流信息
     * @return 订单物流集合
     */
	public List<Ordershipping> selectOrdershippingList(Ordershipping ordershipping);

	/**
     * 新增订单物流
     *
     * @param ordershipping 订单物流信息
     * @return 结果
     */
	public int insertOrdershipping(Ordershipping ordershipping);

	/**
     * 修改订单物流
     *
     * @param ordershipping 订单物流信息
     * @return 结果
     */
	public int updateOrdershipping(Ordershipping ordershipping);

	/**
     * 删除订单物流
     *
     * @param orderId 订单物流ID
     * @return 结果
     */
	public int deleteOrdershippingById(String orderId);

	/**
     * 批量删除订单物流
     *
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrdershippingByIds(String[] orderIds);

}
