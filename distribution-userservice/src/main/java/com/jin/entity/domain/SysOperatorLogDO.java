package com.jin.entity.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author shuai.jin
 * @date 2020/6/28 18:34
 */
@Data
public class SysOperatorLogDO {

    private Integer id;

    private String operatorName;

    private String operatorUri;

    private String operatorModule;

    private Date operatorTime;

    private String operatorIp;

    private String operatorType;

}
