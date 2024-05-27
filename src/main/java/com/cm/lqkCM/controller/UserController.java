package com.cm.lqkCM.controller;

import com.cm.lqkCM.entity.NotificationVo;
import com.cm.lqkCM.entity.UserContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    DataSource dataSource;

    @PostMapping("/api/login/userLogin")
    public NotificationVo userLogin(@RequestBody UserContentVo user) throws Exception {
        System.out.println("用户名"+user.getUserName()+"密码："+user.getPassWord());
        NotificationVo notificationVo = new NotificationVo();

//        ------------------------连接数据库------------------------------------------------------
        Connection connect = dataSource.getConnection();
        PreparedStatement pre = connect.prepareStatement("select * from user_info where username='admin'");
        ResultSet result = pre.executeQuery();
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        while (result.next()) {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("userid", result.getObject("userid"));
            map.put("username", result.getObject("username"));
            map.put("aliasname", result.getObject("aliasname"));
            map.put("password", result.getObject("password"));
            map.put("age", result.getObject("age"));
            map.put("mail", result.getObject("mail"));
            map.put("phone_number", result.getObject("phone_number"));
            map.put("address", result.getObject("address"));
            list.add(map);
        }

        System.out.println(result);
        if(result!= null ) result.close();
        if(pre!= null ) pre.close();
        if(connect!= null ) connect.close();
//        ------------------------------------------------------------------------------







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

}
