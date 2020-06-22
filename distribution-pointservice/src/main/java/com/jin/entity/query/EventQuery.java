package com.jin.entity.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuai.jin
 * @date 2020/6/21 18:34
 */
@Data
public class EventQuery implements Serializable {

    private static final long serialVersionUID = 6511663019541479476L;

    private Integer id;

    private String process;

}
