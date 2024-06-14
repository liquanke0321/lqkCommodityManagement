package com.kmSystem.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContentVo {
    /**
     * 店铺地址，店铺地址
     */
    private String address;
    /**
     * 店铺年龄，店铺年龄
     */
    private Double age;
    /**
     * 昵称，界面显示的名字
     */
    private String aliasname;
    /**
     * 邮箱，店铺关联邮箱
     */
    private String mail;
    /**
     * 密码，登录用的密码
     */
    private String password;
    /**
     * 电话号码，店铺电话号码
     */
    private Double phoneNumber;
    /**
     * 用户ID，用户唯一ID
     */
    private double userid;
    /**
     * 用户名，登录用的用户名
     */
    private String username;

    @Override
    public String toString() {
        return "UserContentVo{" +
                "address='" + address + '\'' +
                ", age=" + age +
                ", aliasname='" + aliasname + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                '}';
    }
}
