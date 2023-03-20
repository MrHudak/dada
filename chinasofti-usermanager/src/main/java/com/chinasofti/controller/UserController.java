package com.chinasofti.controller;

import com.chinasofti.domain.User;
import com.chinasofti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="restful")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> selectUserById(@PathVariable("id") Long id){
        try {
            User user = this.userService.selectUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }catch (Exception e){
            e.printStackTrace();
        }

        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
