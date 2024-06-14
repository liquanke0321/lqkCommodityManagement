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

    public void setReslutMsg(String reslutStatus,String reslutType,String reslutTitle,String reslutMsg) {
        this.reslutStatus = reslutStatus;
        this.reslutType = reslutType;
        this.reslutTitle = reslutTitle;
        this.reslutMsg = reslutMsg;
    }
}
