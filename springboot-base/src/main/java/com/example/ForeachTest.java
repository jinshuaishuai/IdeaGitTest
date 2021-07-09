package com.example;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname ForeachTest
 * @Description TODO
 * @Date 2021/7/7 13:54
 * @Created by jinshuai
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<Object> objects = Arrays.asList();
        for(Object o : objects) {
            System.out.println(o);
        }
    }
}
