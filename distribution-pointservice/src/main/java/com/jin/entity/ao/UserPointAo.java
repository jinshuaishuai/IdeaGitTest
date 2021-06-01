package com.jin.entity.ao;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shuai.jin
 * @date 2021/3/4 17:27
 */
@Data
public class UserPointAo {

    private Integer userId;

    private BigDecimal point;

}
