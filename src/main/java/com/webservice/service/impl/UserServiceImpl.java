package com.webservice.service.impl;

import com.webservice.mapper.UserMapper;
import com.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    public int selectContTest() {
        return userMapper.selectContTest();
    }
}
