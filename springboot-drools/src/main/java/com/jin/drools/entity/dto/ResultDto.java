package com.jin.drools.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author shuai.jin
 * @date 2020/7/21 17:25
 */
@Data
public class ResultDto {

    private String level;

    private Integer userId;

    private String mainAccount;

    private String subAccount;

    /**
     * 数据库中保存的密码
     */
    private String backendPwd;

    /**
     * 登录设备IP
     */
    private String loginIp;

    /**
     * 最近一次登录时间
     */
    private Date loginTime;

    /**
     * 登录类型 1:浏览器登录 2:APP登录
     */
    private Integer loginType;

    @Override
    public String toString() {
        return "ResultDto{" +
                "level='" + level + '\'' +
                ", userId=" + userId +
                ", mainAccount='" + mainAccount + '\'' +
                ", subAccount='" + subAccount + '\'' +
                ", backendPwd='" + backendPwd + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime=" + loginTime +
                ", loginType=" + loginType +
                '}';
    }
}
