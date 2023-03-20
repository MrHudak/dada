package com.chinasofti.mapper;

import com.chinasofti.domain.Productdesc;

import java.util.List;

/**
 * 商品描述 数据层
 *
 * @author huda
 * @date 2019-08-01
 */
public interface ProductdescMapper
{
	/**
     * 查询商品描述信息
     *
     * @param id 商品描述ID
     * @return 商品描述信息
     */
	public Productdesc selectProductdescById(Long id);

	/**
     * 查询商品描述列表
     *
     * @param productdesc 商品描述信息
     * @return 商品描述集合
     */
	public List<Productdesc> selectProductdescList(Productdesc productdesc);

	/**
     * 新增商品描述
     *
     * @param productdesc 商品描述信息
     * @return 结果
     */
	public int insertProductdesc(Productdesc productdesc);

	/**
     * 修改商品描述
     *
     * @param productdesc 商品描述信息
     * @return 结果
     */
	public int updateProductdesc(Productdesc productdesc);

	/**
     * 删除商品描述
     *
     * @param id 商品描述ID
     * @return 结果
     */
	public int deleteProductdescById(Long id);

	/**
     * 批量删除商品描述
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductdescByIds(String[] ids);

}
