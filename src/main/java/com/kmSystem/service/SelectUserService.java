package com.kmSystem.service;

import com.kmSystem.entity.UserContentVo;

import java.util.List;

public interface SelectUserService {

    List<UserContentVo> selectAll(String username, String password);
}
