package com.chinasofti.mapper;

import com.chinasofti.domain.Orderproduct;

import java.util.List;

/**
 * 订单详情 数据层
 *
 * @author huda
 * @date 2019-08-01
 */
public interface OrderproductMapper
{
	/**
     * 查询订单详情信息
     *
     * @param productId 订单详情ID
     * @return 订单详情信息
     */
	public Orderproduct selectOrderproductById(String productId);

	/**
     * 查询订单详情列表
     *
     * @param orderproduct 订单详情信息
     * @return 订单详情集合
     */
	public List<Orderproduct> selectOrderproductList(Orderproduct orderproduct);

	/**
     * 新增订单详情
     *
     * @param orderproduct 订单详情信息
     * @return 结果
     */
	public int insertOrderproduct(Orderproduct orderproduct);

	/**
     * 修改订单详情
     *
     * @param orderproduct 订单详情信息
     * @return 结果
     */
	public int updateOrderproduct(Orderproduct orderproduct);

	/**
     * 删除订单详情
     *
     * @param productId 订单详情ID
     * @return 结果
     */
	public int deleteOrderproductById(String productId);

	/**
     * 批量删除订单详情
     *
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderproductByIds(String[] productIds);

}
