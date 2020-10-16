package com.jin.entity.ao;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shuai.jin
 * @date 2020/9/17 15:05
 */
@Data
@Builder
public class GoodsAo {

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsQuantity;

    private String goodsSku;

    private String goodsSpu;

    private String color;
}
