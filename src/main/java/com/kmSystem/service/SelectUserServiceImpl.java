package com.kmSystem.service;

import com.kmSystem.entity.UserContentVo;
import com.kmSystem.mapper.SelectUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class SelectUserServiceImpl implements SelectUserService {
    @Autowired
    private SelectUserMapper selectUserMapper;

    @Override
    public List<UserContentVo> selectAll(String username, String password) {
        return selectUserMapper.selectAll(username,password);
    }
}
