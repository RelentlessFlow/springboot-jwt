package com.yzq.springbootjwt.mapper;

import com.yzq.springbootjwt.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User findByUsername(@Param("username") String username);
    User findUserById(@Param("Id") String Id);
}
