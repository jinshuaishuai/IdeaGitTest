package com.poi.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2021/7/9 15:15
 * @Created by jinshuai
 */
@Data
public class Student {

    @ExcelProperty(value = "别名")
    private String alias;

    @ExcelProperty(value = "姓名")
    private String name;

    @ExcelProperty(value = "年龄")
    private int age;

    @ExcelProperty(value = "id")
    private int id;
}
