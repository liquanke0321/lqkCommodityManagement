package com.kmSystem.mapper;

import com.kmSystem.entity.UserContentVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SelectUserMapper {
    @Select({
            "select","*",
            "from user_info","where","username = #{username} and password = #{password}"
    })
    List<UserContentVo> selectAll(@Param("username") String username, @Param("password") String password);

}
