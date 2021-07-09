package com.poi.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Classname DataModel
 * @Description TODO
 * @Date 2021/7/9 14:40
 * @Created by jinshuai
 */
@Data
public class DataModel {

    @ExcelProperty(value = "关联采购单号")
    private String purOrder;

    @ExcelProperty(value = "修复原因")
    private String reason;

    @ExcelProperty(value = "期望完成时间")
    private String time;


    @ExcelProperty(value = "期望处理状态（含税单价）")
    private BigDecimal price;

    @ExcelProperty(value = "SKU(辅助信息)")
    private String sku;

    @ExcelProperty(value = "MSKU(辅助信息)")
    private String msku;

    @ExcelProperty(value = "含税单价")
    private String pri;

    @ExcelProperty(value = "已交量（辅助信息）")
    private String bbb;

    @ExcelProperty(value = "含税货值（辅助信息）")
    private String ccc;

    @ExcelProperty(value = "交货单号（辅助信息）")
    private String jhdh;

}
