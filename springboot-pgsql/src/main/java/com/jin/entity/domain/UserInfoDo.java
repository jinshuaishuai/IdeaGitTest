package com.jin.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDo implements Serializable {

    private static final long serialVersionUID = 584474155538846643L;

    private Integer id;

    private String name;

    private Integer age;

    private String phone;

    private Byte isDelete;

    private String createTime;

    private String updateTime;
}
