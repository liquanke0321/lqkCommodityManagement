package com.kmSystem.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationVo {

    private String reslutStatus;
    private String reslutType;
    private String reslutTitle;
    private String reslutMsg;
    private UserContentVo userContentVo = new UserContentVo();

}