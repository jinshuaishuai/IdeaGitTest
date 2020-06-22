package com.jin.entity.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuai.jin
 * @date 2020/6/20 8:01
 */
@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = -4553356176214119782L;

    private Integer id;

    private String name;

    private String phone;

    private Integer age;

}
