package com.chinasofti.mapper;

import com.chinasofti.domain.Category;

import java.util.List;

/**
 * 菜单分类 数据层
 *
 * @author huda
 * @date 2019-08-01
 */
public interface CategoryMapper
{
	/**
     * 查询菜单分类信息
     *
     * @param id 菜单分类ID
     * @return 菜单分类信息
     */
	public Category selectCategoryById(Long id);

	/**
     * 查询菜单分类列表
     *
     * @param category 菜单分类信息
     * @return 菜单分类集合
     */
	public List<Category> selectCategoryList(Category category);

	/**
     * 新增菜单分类
     *
     * @param category 菜单分类信息
     * @return 结果
     */
	public int insertCategory(Category category);

	/**
     * 修改菜单分类
     *
     * @param category 菜单分类信息
     * @return 结果
     */
	public int updateCategory(Category category);

	/**
     * 删除菜单分类
     *
     * @param id 菜单分类ID
     * @return 结果
     */
	public int deleteCategoryById(Long id);

	/**
     * 批量删除菜单分类
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCategoryByIds(String[] ids);

}
