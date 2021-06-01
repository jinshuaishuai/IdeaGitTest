package com.poi.example;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteWorkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shuai.jin
 * @date 2021/3/2 16:55
 */
public class AliEasyExcel {

    public static void main(String[] args) {

        writeManySheet();

    }

    private static void normalWrite() {
        EasyExcel.write(new File("D:/3.xls")).head(head()).sheet("sheet1").doWrite(dataList());
    }

    private static void writeManySheet() {
        File file = new File("D:/2.xls");
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(file).build();
            for(int i = 0; i < 5; i++) {
                WriteSheet writeSheet = EasyExcel.writerSheet("sheet" + (i + 1)).head(head()).build();
                excelWriter.write(dataList(), writeSheet);
            }


        }finally {
            if(excelWriter != null) {
                excelWriter.finish();
            }
        }
    }


    private static List<List<Object>> dataList() {
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> row1 = new ArrayList<>();
        row1.add("1");
        row1.add(2);
        row1.add(3);

        List<Object> row2 = new ArrayList<>();
        row2.add("a");
        row2.add("b");
        row2.add("c");

        dataList.add(row1);
        dataList.add(row2);

        return dataList;
    }

    private static List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();

        List<String> h0 = new ArrayList<>();
        h0.add("字段1");

        List<String> h1 = new ArrayList<>();
        h1.add("字段2");

        List<String> h2 = new ArrayList<>();
        h2.add("字段3");

        list.add(h0);
        list.add(h1);
        list.add(h2);

        return list;
    }
}
