package com.jin.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shuai.jin
 * @date 2020/10/26 18:23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoubleEleDo implements Serializable {

    private Long id;

    private String shopName;

    private String name;

    private Integer age;

    private String phone;

    private Date createTime;

    private Date updateTime;

    private Integer isDelete;

    private Integer type;

    private Integer status;


}
