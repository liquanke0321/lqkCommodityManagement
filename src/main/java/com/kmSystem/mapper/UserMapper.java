package com.kmSystem.mapper;

import com.kmSystem.entity.UserContentVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //这种是使用@Param传值的,在xml中取值要用 对象.属性 的方式去出字段值
    List<UserContentVo> selectUser( @Param("user")UserContentVo user);
}
