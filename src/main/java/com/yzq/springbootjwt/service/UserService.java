package com.yzq.springbootjwt.service;

import com.yzq.springbootjwt.entity.User;
import com.yzq.springbootjwt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findByUsername(User user){
        return userMapper.findByUsername(user.getUsername());
    }
    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

}
