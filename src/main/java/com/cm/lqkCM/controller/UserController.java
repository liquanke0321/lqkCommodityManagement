package com.cm.lqkCM.controller;

import com.cm.lqkCM.entity.NotificationVo;
import com.cm.lqkCM.entity.UserContentVo;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @PostMapping("/api/login/userLogin")
    public NotificationVo userLogin(@RequestBody UserContentVo user) {
        System.out.println("用户名"+user.getUserName()+"密码："+user.getPassWord());
        NotificationVo notificationVo = new NotificationVo();
        user.setAliasName("小李");
        if ("123".equals(user.getUserName()) && "123".equals(user.getPassWord())) {
            notificationVo.setReslutStatus("OK");
            notificationVo.setReslutType("success");
            notificationVo.setReslutTitle("登陆成功");
            notificationVo.setReslutMsg(user.getAliasName()+"欢迎进入");
            return notificationVo;
        }else {
            notificationVo.setReslutStatus("NG");
            notificationVo.setReslutType("error");
            notificationVo.setReslutTitle("登陆失败");
            notificationVo.setReslutMsg("用户名或密码不正确");
            return notificationVo;
        }

    }



//
//    @PostMapping("/api/login/userLogin")
//    public String hello(@RequestParam("username") String username, @RequestParam("password") String password) {
//        System.out.println("用户名"+username+"密码："+password);
//        if ("123".equals(username) && "123".equals(password)) {
//            return "{\n" +
//                    "    \"reslut\": \"OK\",\n" +
//                    "    \"reslutType\": \"success\",\n" +
//                    "    \"reslutTitle\": \"登陆成功\",\n" +
//                    "    \"reslutMsg\": \""+username+"欢迎进入\"\n" +
//                    "}";
//
//        }else {
//            return "{\n" +
//                    "    \"reslut\": \"NG\",\n" +
//                    "    \"reslutType\": \"error\",\n" +
//                    "    \"reslutTitle\": \"登陆失败\",\n" +
//                    "    \"reslutMsg\": \"用户名或密码不正确\"\n" +
//                    "}";
//
//        }
//
//    }
//
//    @GetMapping("/api/login/userLogin")
//    public String hello2(@RequestParam("username") String username,@RequestParam("password") String password) {
//        System.out.println("用户名" + username + "密码：" + password);
//        if ("123".equals(username) && "123".equals(password)) {
//            return "{\n" +
//                    "    \"reslut\": \"OK\",\n" +
//                    "    \"reslutType\": \"success\",\n" +
//                    "    \"reslutTitle\": \"登陆成功\",\n" +
//                    "    \"reslutMsg\": \"" + username + "欢迎进入\"\n" +
//                    "}";
//
//        } else {
//            return "{\n" +
//                    "    \"reslut\": \"NG\",\n" +
//                    "    \"reslutType\": \"error\",\n" +
//                    "    \"reslutTitle\": \"登陆失败\",\n" +
//                    "    \"reslutMsg\": \"用户名或密码不正确\"\n" +
//                    "}";
//
//        }
//    }




}
