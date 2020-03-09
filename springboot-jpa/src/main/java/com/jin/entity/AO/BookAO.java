package com.jin.entity.AO;

import lombok.Data;

import java.math.BigDecimal;

@Data

public class BookAO {

    private Integer id;

    private String bookName;

    private BigDecimal bookPrice;

    private String address;

    private String phone;

    private Integer isDelete;

    private String createTime;

    private String updateTime;
}
