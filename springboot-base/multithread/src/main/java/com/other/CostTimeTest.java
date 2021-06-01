package com.other;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author shuai.jin
 * @date 2021/5/13 14:10
 */
public class CostTimeTest {

    public static void main(String[] args) {

        loadData();
    }

    private static void loadData() {
        File file = new File("D:/data/CostTimeTest.class");
        System.out.println(file.exists());
    }
}
