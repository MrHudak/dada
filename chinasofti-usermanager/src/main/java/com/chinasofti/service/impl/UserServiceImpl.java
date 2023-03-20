package com.chinasofti.service.impl;

import com.chinasofti.domain.User;
import com.chinasofti.mapper.UserMapper;
import com.chinasofti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(Long id) {
        User user = this.userMapper.selectUserById(id);
        return user;
    }

    @Override
    public List<User> selectUserList(User user) {
        return this.userMapper.selectUserList(user);
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(Long id) {

    }
}