package com.poi.example;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.*;

/**
 * @author shuai.jin
 * @date 2020/10/16 14:55
 */
public class MainTest {

    public static void main(String[] args) {
        ExcelWriter writer = ExcelUtil.getWriter("d:/aaa.xlsx");
        List<Map<String, Object>> maps = new ArrayList<>();
        Map<String, Object> map1 = new LinkedHashMap<>();
        map1.put("id", 1);
        map1.put("name", "very");
        map1.put("age", 1);

        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("id", 2);
        map2.put("goods", "good");
        map2.put("age", 3);
        map2.put("hello", "world");

        maps.add(map2);
        maps.add(map1);

        List<String> headList = new ArrayList<>();
        headList.add("a");
//        headList.add("b");
//        headList.add("c");
//        headList.add("d");



        writer.writeHeadRow(headList);
        writer.write(maps);

        writer.close();
    }
}
