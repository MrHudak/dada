package com.chinasofti.service;


import com.chinasofti.domain.Category;

import java.util.List;

public interface CategoryService {


    //查询所有分类信息
    public List<Category> selectCategoryList(Category category);

}
