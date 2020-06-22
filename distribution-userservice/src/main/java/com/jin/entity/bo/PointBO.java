package com.jin.entity.bo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shuai.jin
 * @date 2020/6/20 17:14
 */
@Data
public class PointBO implements Serializable {

    private static final long serialVersionUID = -2435171512286490860L;

    private Integer userId;

    private BigDecimal point;

}
