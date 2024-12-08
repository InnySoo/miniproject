package com.sooin.miniproject.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.sooin.miniproject.models.User;

@Mapper
public interface UserMapper {
    
    User findByUserId(int userId);

    User findByUserName(String userName);

}
