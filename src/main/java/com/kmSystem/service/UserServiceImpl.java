package com.kmSystem.service;

import com.kmSystem.entity.UserContentVo;
import com.kmSystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserContentVo> selectAll(String username, String password) {
        return userMapper.selectAll(username,password);
    }
}
