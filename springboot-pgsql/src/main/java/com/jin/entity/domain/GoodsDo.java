package com.jin.entity.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shuai.jin
 * @date 2020/9/17 15:36
 */
@Data
public class GoodsDo {

    private Integer id;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsQuantity;

    private String goodsSku;

    private String goodsSpu;

    private String color;

    private Integer isDelete;

}
