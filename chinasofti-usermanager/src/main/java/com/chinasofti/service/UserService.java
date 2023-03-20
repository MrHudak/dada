package com.chinasofti.service;


import com.chinasofti.domain.User;
//import com.chinasofti.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
   public User selectUserById(Long id);


    /**
     * 根据条件查询用户列表
     * @param user
     * @return
     */
   public  List<User> selectUserList(User user);

    /**
     * 添加用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 更新用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    public void deleteUserById(Long id);
}
