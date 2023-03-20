package com.chinasofti.mapper;

import com.chinasofti.domain.Cart;

import java.util.List;

/**
 * 购物车 数据层
 *
 * @author huda
 * @date 2019-08-01
 */
public interface CartMapper
{
	/**
     * 查询购物车信息
     *
     * @param id 购物车ID
     * @return 购物车信息
     */
	public Cart selectCartById(Long id);

	/**
     * 查询购物车列表
     *
     * @param cart 购物车信息
     * @return 购物车集合
     */
	public List<Cart> selectCartList(Cart cart);

	/**
     * 新增购物车
     *
     * @param cart 购物车信息
     * @return 结果
     */
	public int insertCart(Cart cart);

	/**
     * 修改购物车
     *
     * @param cart 购物车信息
     * @return 结果
     */
	public int updateCart(Cart cart);

	/**
     * 删除购物车
     *
     * @param id 购物车ID
     * @return 结果
     */
	public int deleteCartById(Long id);

	/**
     * 批量删除购物车
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCartByIds(String[] ids);

}
