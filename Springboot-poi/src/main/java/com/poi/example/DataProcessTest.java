package com.poi.example;

import com.alibaba.excel.EasyExcel;
import com.poi.example.entity.DataModel;
import com.poi.example.listener.DataReadListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DataProcess
 * @Description TODO
 * @Date 2021/7/9 14:37
 * @Created by jinshuai
 */
public class DataProcessTest {
    public static void main(String[] args) throws IOException {
        List<DataModel> list = new ArrayList<>();



        File file = new File("D:\\develop\\工作文件\\强哥数据修复\\首加交货单价数据修复申请4发肖工.xls");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println(file.exists());
        EasyExcel.read(file, DataModel.class, new DataReadListener()).sheet("Sheet1").doRead();


    }
}
