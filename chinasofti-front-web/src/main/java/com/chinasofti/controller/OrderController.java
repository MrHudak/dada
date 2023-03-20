package com.chinasofti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "order")
 @Controller
 public class OrderController {

         /**
  * 显示订单详情信息页
  */
         @RequestMapping(value = "orderinfo.html",method = RequestMethod.GET)
 public ModelAndView showOrderInfo(){
         ModelAndView mv = new ModelAndView("orderinfo");
         return mv;
         }
 }
