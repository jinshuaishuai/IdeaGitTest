package com.poi.example.test;

import com.alibaba.excel.EasyExcel;
import com.poi.example.entity.Student;
import com.poi.example.listener.StudentListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname StudentTest
 * @Description TODO
 * @Date 2021/7/9 15:17
 * @Created by jinshuai
 */
public class StudentTest {
    public static void main(String[] args) {
        File file = new File("D:\\develop\\工作文件\\强哥数据修复\\学生表.xls");


        EasyExcel
                .read(file, Student.class, new StudentListener())
                .sheet("Sheet1")
                .headRowNumber(2)
                .doRead();
    }
}
