package com.chinasofti.controller;

import com.chinasofti.domain.User;
import com.chinasofti.service.UserService;
import com.chinasofti.utils.CookieUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "user")
@Controller
public class UserController {
        private static final ObjectMapper MAPPER = new ObjectMapper();


        @Autowired
        private UserService userService;
    /**
     * 显示注册页
     */
    @RequestMapping(value = "reg.html",method = RequestMethod.GET)
    public ModelAndView showReg(){
        ModelAndView mv = new ModelAndView("reg");
        return mv;
    }
    /**
     * 实现注册
     */
    @RequestMapping(value = "doreg.html",method = RequestMethod.POST)
    public String doReg(User user){
        ResponseEntity<String> result = userService.regester(user);
        if (result.getStatusCode().value()==200){
            //注册成功
            return "redirect:/";
        }else {
            //注册失败
            return "redirect:/user/reg.html";
        }
    }

    /**
     * 显示登录页
     */
    @RequestMapping(value = "login.html",method = RequestMethod.GET)
    public ModelAndView showLogin(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    /**
     * 实现用户登录功能
     */
    @RequestMapping(value = "dologin.html",method = RequestMethod.POST)
    public String dologin(@RequestParam("loginname") String loginname,
                          @RequestParam("nloginpwd") String nloginpwd,
                          HttpServletRequest request,
                          HttpServletResponse response){
        ResponseEntity<String> result = userService.login(loginname,nloginpwd);
        if(result.getBody()==null){
            //登录失败
            return "redirect:/user/login.html";
        }else{
            //登录成功
            //向浏览器生成cookie
            CookieUtils.setCookie(request,response,"CHINASOFTI_TICKET",result.getBody(),true);
            return "redirect:/";
        }
    }


}
