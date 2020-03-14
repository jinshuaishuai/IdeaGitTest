package com.jin.entity.query;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookQuery {

    private int id;

    private String bookName;

    private BigDecimal bookPrice;
}
