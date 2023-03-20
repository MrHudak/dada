package com.chinasofti.interceptor;

import com.chinasofti.domain.User;
import com.chinasofti.service.UserService;
import com.chinasofti.utils.CookieUtils;
import com.chinasofti.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
 public class UserLoginInterceptor implements HandlerInterceptor {

         @Autowired
 private UserService userService;

         @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                          Object handler) throws Exception {
         String ticket = CookieUtils.getCookieValue(request, "CHINASOFTI_TICKET", true);
         if (StringUtils.isEmpty(ticket)){
             //没有登录
             response.sendRedirect("/user/login.html");
             return false;
             }

         ResponseEntity<User> responseEntity = userService.selectUserByTicket(ticket);

         //如果ticket不为空,证明用户登录过,要判断是否失效
         if (responseEntity.getBody() == null){
             //用户登录失效
             response.sendRedirect("/user/login.html");
             return false;
             }
         return true;
         }

         @Override
 public void postHandle(HttpServletRequest request, HttpServletResponse response,
                          Object handler, ModelAndView modelAndView) throws Exception {

         }

         @Override
 public void afterCompletion(HttpServletRequest request, HttpServletResponse
            response, Object handler, Exception ex) throws Exception {

         }
 }
