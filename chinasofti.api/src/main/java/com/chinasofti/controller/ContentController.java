package com.chinasofti.controller;

import com.chinasofti.domain.Content;
import com.chinasofti.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/restful")
 @RestController
 public class ContentController {

         @Autowired
 private ContentService contentService;
 /**
  * 根据类目id查询广告列表
  */
         @RequestMapping(value = "content/{categoryid}",method = RequestMethod.GET)
 public ResponseEntity<List<Content>>
    selectContentListByCategoryId(@PathVariable("categoryid") Long categoryId){
         try {
             Content content = new Content();
             content.setCategoryid(categoryId);
             List<Content> list = this.contentService.selectContentList(content);
             return ResponseEntity.status(HttpStatus.OK).body(list);
             }catch (Exception e){
             e.printStackTrace();
             }
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }
 }