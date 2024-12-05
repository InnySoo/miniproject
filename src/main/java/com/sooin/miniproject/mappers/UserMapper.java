package com.sooin.miniproject.mappers;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.sooin.miniproject.models.User;

@Mapper
public interface UserMapper {
    
    Optional<User> findByUserId(int userId);

    Optional<User> findByUserName(String userName);

}
