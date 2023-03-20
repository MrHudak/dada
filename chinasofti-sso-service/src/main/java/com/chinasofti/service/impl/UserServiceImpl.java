package com.chinasofti.service.impl;

import com.chinasofti.domain.User;
import com.chinasofti.mapper.UserMapper;
import com.chinasofti.service.UserService;
import com.chinasofti.utils.RedisUtils;
import com.chinasofti.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private RedisUtils redisUtils;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public Boolean check(String param, Integer type) {
        User user = new User();
        switch (type){
            case 1:
                user.setUsername(param);
                break;
            case 2:
                user.setPhone(param);
                break;
            case 3:
                user.setEmail(param);
                break;
            default:
                break;
        }

        List<User> list = this.userMapper.selectUserList(user);
        if(list.size()>0){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 用户注册
     * @param user
     */
    @Override
    public void regester(User user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userMapper.insertUser(user);
    }

    /**
     * 用户登录
     */
    @Override
    public String login(String username, String password) throws Exception{
//        //select * from `user` where username='zhangsan' and
//         `password`='e10adc3949ba59abbe56e057f20f883e'
//        //想办法提高Sql的执行效率
        User user = new User();
        user.setUsername(username);

        List<User> list = this.userMapper.selectUserList(user);
        User user1 = null;
        if (list.size()>0){
            user1 = list.get(0);
            if (!StringUtils.equals(user1.getPassword(),DigestUtils.md5Hex(password))){
                //登录失败
                return null;
            }
        }
        //登录成功
        //生成ticket 唯一,不能太长
        String ticket = DigestUtils.md5Hex(System.currentTimeMillis()+username);
        this.redisUtils.set(ticket,MAPPER.writeValueAsString(user1),1800);
        return ticket;
    }

    /**
     * 根据ticket查询用户信息
     * @param ticket
     * @return
     */
    @Override
    public User selectUserByTicket(String ticket) {
        Object obj = this.redisUtils.get(ticket);
        try {
            if (obj!=null){
                User user = MAPPER.readValue(obj.toString(), User.class);
                //注意重置Session
                this.redisUtils.expire(ticket,1800);
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
