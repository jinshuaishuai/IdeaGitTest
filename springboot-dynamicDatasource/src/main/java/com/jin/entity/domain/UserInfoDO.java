package com.jin.entity.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:23
 */
@Data
public class UserInfoDO implements Serializable {

    private static final long serialVersionUID = 584474155538846643L;

    private Integer id;

    private String name;

    private Integer age;

    private String phone;

    private Byte isDelete;

    private String createTime;

    private String updateTime;
}
