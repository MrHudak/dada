package com.chinasofti.service;

import com.chinasofti.domain.Content;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("CHINASOFTI-API")

         public interface ContentService {


         @RequestMapping(value = "/api/restful/content/{categoryid}",method =
            RequestMethod.GET)
 public ResponseEntity<List<Content>>
    selectContentListByCategoryId(@PathVariable("categoryid") Long categoryId);
 }
