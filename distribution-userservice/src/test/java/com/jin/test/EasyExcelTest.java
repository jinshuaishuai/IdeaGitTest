package com.jin.test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import org.junit.Test;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/29 13:45
 */
public class EasyExcelTest {

    @Test
    public void testExcelRead() {
        ExcelReaderBuilder readerBuilder = EasyExcelFactory.read("D:\\develop\\!!!!!!!!!!!!!!Java学习\\第049天 SpringBoot的学习\\SpringBoot集成EasyExcel\\test.xlsx");
        List<Object> objects = readerBuilder.doReadAllSync();
        System.out.println(objects);

    }
}
