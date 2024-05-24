package com.cm.lqkCM.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContentVo {
    private int id;
    private String aliasName;
    private String passWord;
    private String userName;
    private String age;
    private String mail;
    private String phoneNumber;
    private String address;
}
