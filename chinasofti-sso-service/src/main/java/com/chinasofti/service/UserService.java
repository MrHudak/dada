package com.chinasofti.service;

import com.chinasofti.domain.User;

public interface UserService {
 //检查用户是否可用
         public Boolean check(String param, Integer type);
 //注册用户
         public void regester(User user);
 //用户登录
         public String login(String username, String password) throws Exception;
 //根据ticket查询用户信息
         public User selectUserByTicket(String ticket);
 }

