package com.chinasofti.service;

import com.chinasofti.domain.Contentcategory;

import java.util.List;

public interface ContentcategoryService {

    //查询所有内容分类信息
    public List<Contentcategory> selectContentcategoryList(Contentcategory contentcategory);

    //添加子类目
    public  void insertContentCategory(Contentcategory contentcategory);

//    修改类目
    public void updateContentCategory(Contentcategory contentcategory);

    public void deleteContentCategory(Contentcategory contentcategory);
}
