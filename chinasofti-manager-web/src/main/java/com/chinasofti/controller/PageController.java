package com.chinasofti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/restful/page")
 @Controller
 public class PageController {

         /**
  * 实现通用的页面跳转
  * /restful/page/{pageName}
  */
         @RequestMapping(value = "{pageName}",method = RequestMethod.GET)
 public String toPage(@PathVariable("pageName") String pageName, Model modle){
         return "/"+pageName;
         }
 }

