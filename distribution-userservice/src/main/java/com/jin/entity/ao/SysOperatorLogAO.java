package com.jin.entity.ao;

import lombok.Data;

import java.util.Date;

/**
 * @author shuai.jin
 * @date 2020/6/28 18:22
 */
@Data
public class SysOperatorLogAO {

    private String operatorName;

    private String operatorUri;

    private String operatorModule;

    private Date operatorTime;

    private String operatorIp;

    private String operatorType;

}
