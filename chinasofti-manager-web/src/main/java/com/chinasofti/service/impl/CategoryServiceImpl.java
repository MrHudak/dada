package com.chinasofti.service.impl;

import com.chinasofti.domain.Category;
import com.chinasofti.mapper.CategoryMapper;
import com.chinasofti.service.CategoryService;
import com.chinasofti.utils.RedisUtils;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisUtils redisUtils;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public List<Category> selectCategoryList(Category category) {
        List<Category>  list = new ArrayList<>();
        try {
            Object tree_menu = this.redisUtils.get("CHINASOFTI_MANAGER_CATEGORY_TREE_MENU");

            if (tree_menu!=null){
                //命中缓存
                JavaType javaType = MAPPER.getTypeFactory().constructParametricType(ArrayList.class,Category.class);
                list = MAPPER.readValue(tree_menu.toString(),javaType);
            }else{
                //从数据库中获取
                list =  this.categoryMapper.selectCategoryList(category);

                //加入缓存
                redisUtils.set("CHINASOFTI_MANAGER_CATEGORY_TREE_MENU",MAPPER.writeValueAsString(list),60*60*24*30);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
