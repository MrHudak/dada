package com.chinasofti.service;

import com.chinasofti.domain.Content;

import java.util.List;

public interface ContentService {
 //查询商品列表
         public List<Content> selectContentList(Content content);

         //添加商品广告
         public void insertContent(Content content);

         //批量删除商品广告
         public void deleteContentByIds(String ids);
 }
