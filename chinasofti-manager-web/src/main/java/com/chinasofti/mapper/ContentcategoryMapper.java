package com.chinasofti.mapper;

import com.chinasofti.domain.Contentcategory;

import java.util.List;

/**
 * 内容分类 数据层
 *
 * @author huda
 * @date 2019-08-01
 */
public interface ContentcategoryMapper
{
	/**
     * 查询内容分类信息
     *
     * @param id 内容分类ID
     * @return 内容分类信息
     */
	public Contentcategory selectContentcategoryById(Long id);

	/**
     * 查询内容分类列表
     *
     * @param contentcategory 内容分类信息
     * @return 内容分类集合
     */
	public List<Contentcategory> selectContentcategoryList(Contentcategory contentcategory);

	/**
     * 新增内容分类
     *
     * @param contentcategory 内容分类信息
     * @return 结果
     */
	public int insertContentcategory(Contentcategory contentcategory);

	/**
     * 修改内容分类
     *
     * @param contentcategory 内容分类信息
     * @return 结果
     */
	public int updateContentcategory(Contentcategory contentcategory);

	/**
     * 删除内容分类
     *
     * @param id 内容分类ID
     * @return 结果
     */
	public int deleteContentcategoryById(Long id);

	/**
     * 批量删除内容分类
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteContentcategoryByIds(String[] ids);

}
