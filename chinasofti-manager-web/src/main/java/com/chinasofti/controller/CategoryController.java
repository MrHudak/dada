package com.chinasofti.controller;

import com.chinasofti.domain.Category;
import com.chinasofti.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/restful/page")
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 显示树菜单信息
     */
    @RequestMapping(value = "category",method = RequestMethod.GET)
    public ResponseEntity<List<Category>> selectCategoryList(Category category){

        try{
            List<Category> list = this.categoryService.selectCategoryList(category);
            //200
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
