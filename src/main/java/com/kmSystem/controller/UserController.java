package com.kmSystem.controller;

import com.kmSystem.entity.NotificationVo;
import com.kmSystem.entity.UserContentVo;
import com.kmSystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserMapper userMapper;

    @PostMapping("/api/login/userLogin")
    public NotificationVo userLogin(@RequestBody UserContentVo user) throws Exception {
        NotificationVo notificationVo = new NotificationVo();
        // 检索
        List<UserContentVo> userContentVoList = userMapper.selectUser(user);
        if (!userContentVoList.isEmpty()) {
            //返回值设定
            user.setAliasname(userContentVoList.get(0).getAliasname());
            user.setMail(userContentVoList.get(0).getMail());
            user.setAge(userContentVoList.get(0).getAge());
            user.setAddress(userContentVoList.get(0).getAddress());
            user.setPhoneNumber(userContentVoList.get(0).getPhoneNumber());
            user.setUserid(userContentVoList.get(0).getUserid());

            //弹窗信息设定
            notificationVo.setReslutStatus("OK");
            notificationVo.setReslutType("success");
            notificationVo.setReslutTitle("登陆成功");
            notificationVo.setReslutMsg(user.getAliasname() + "欢迎进入");
            notificationVo.setUserContentVo(user);
            return notificationVo;
        } else {
            notificationVo.setReslutStatus("NG");
            notificationVo.setReslutType("error");
            notificationVo.setReslutTitle("登陆失败");
            notificationVo.setReslutMsg("用户名或密码不正确");
            return notificationVo;
        }

    }
}
