package com.kmSystem.controller;

import com.kmSystem.entity.NotificationVo;
import com.kmSystem.entity.UserContentVo;
import com.kmSystem.service.UserService;
import com.kmSystem.service.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @PostMapping("/api/login/userLogin")
    public NotificationVo userLogin(@RequestBody UserContentVo user) throws Exception {
        NotificationVo notificationVo = new NotificationVo();

        List<UserContentVo> userContentVoList =  selectAll(user.getUsername(),user.getPassword());
        if (!userContentVoList.isEmpty()) {
            user.setUsername(userContentVoList.get(0).getUsername());
            user.setPassword(userContentVoList.get(0).getPassword());
            user.setAliasname(userContentVoList.get(0).getAliasname());
            user.setMail(userContentVoList.get(0).getMail());
            user.setAge(userContentVoList.get(0).getAge());
            user.setAddress(userContentVoList.get(0).getAddress());
            user.setPhoneNumber(userContentVoList.get(0).getPhoneNumber());
            user.setUserid(userContentVoList.get(0).getUserid());

            notificationVo.setReslutStatus("OK");
            notificationVo.setReslutType("success");
            notificationVo.setReslutTitle("登陆成功");
            notificationVo.setReslutMsg(user.getAliasname()+"欢迎进入");
            notificationVo.setUserContentVo(user);
            return notificationVo;
        }else {
            notificationVo.setReslutStatus("NG");
            notificationVo.setReslutType("error");
            notificationVo.setReslutTitle("登陆失败");
            notificationVo.setReslutMsg("用户名或密码不正确");
            return notificationVo;
        }

    }



    @Resource
    private UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<UserContentVo> selectAll(String username, String password) {
        List<UserContentVo> list = userService.selectAll(username,password);
        return list;
    }


}
