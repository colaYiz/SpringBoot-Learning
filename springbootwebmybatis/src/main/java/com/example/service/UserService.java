package com.example.service;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


public interface UserService {
    User selectPasswordByName(String userName,String password);
}
