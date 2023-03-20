package com.chinasofti.controller;

import com.chinasofti.domain.User;
import com.chinasofti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
 public class UserController {

         @Autowired
 private UserService userService;

         /**
  * 检查用户是否可用
  */
         @RequestMapping(value = "/check/{param}/{type}",method = RequestMethod.GET)
 @ResponseBody
 public ResponseEntity<Boolean> check(@PathVariable("param") String param,
                                      @PathVariable("type") Integer type){
         try {
             Boolean bool = this.userService.check(param,type);
             return ResponseEntity.status(HttpStatus.OK).body(bool);
             }catch (Exception e){
             e.printStackTrace();
             }
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
         }

         /**
  * 用户注册
  */
         @RequestMapping(value = "/register",method = RequestMethod.POST)
 @ResponseBody
 public ResponseEntity<String> regester(@RequestBody User user){
         try {
             //表单验证 TOdo....

             this.userService.regester(user);
             //201
             return ResponseEntity.status(HttpStatus.CREATED).body(null);
             }catch (Exception e){
             e.printStackTrace();
             }
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }


         /**
  * 用户登录
  * @return ticket串
  */
         @RequestMapping(value = "login",method = RequestMethod.POST)
 @ResponseBody
 public ResponseEntity<String> login(@RequestParam("username") String username,
 @RequestParam("password") String password){

         try {
             String ticket = this.userService.login(username,password);
             if (ticket == null){
                 //登录失败
                 return ResponseEntity.ok(null);
                 }else{
                 //登录成功
                 return ResponseEntity.ok(ticket);
                 }
             }catch (Exception e){
             e.printStackTrace();
             }
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }

         /**
  * 根据ticket查询用户信息
  */
         @RequestMapping(value = "/user/{ticket}",method = RequestMethod.GET)
 @ResponseBody
 public ResponseEntity<User> selectUserByTicket(@PathVariable("ticket") String
                                                          ticket){
         try {
             User user = this.userService.selectUserByTicket(ticket);
             if (user!= null){
                 //redis中获取用户信息没有失效
                 return ResponseEntity.ok(user);
                 }else {
                 //用户失效
                 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
                 }
             }catch (Exception e){
             e.printStackTrace();
             }
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }
 }
