package com.chinasofti.service;

import com.chinasofti.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("SSO-SERVICE")
 public interface UserService {

         @RequestMapping(value = "/register",method = RequestMethod.POST)
         ResponseEntity<String> regester(@RequestBody User user);

         @RequestMapping(value = "/login",method = RequestMethod.POST)
 ResponseEntity<String> login(@RequestParam("username") String username,
 @RequestParam("password") String password);

         @RequestMapping(value = "user/{ticket}",method = RequestMethod.GET)
 ResponseEntity<User> selectUserByTicket(@PathVariable("ticket") String ticket);

         }
