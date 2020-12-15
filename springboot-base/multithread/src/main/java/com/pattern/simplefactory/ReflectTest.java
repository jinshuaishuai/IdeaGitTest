package com.pattern.simplefactory;

import java.util.HashMap;

/**
 * @author shuai.jin
 * @date 2020/11/10 11:54
 */
public class ReflectTest {


    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<String, String>();

        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("hello");
            hashMap.put("" + i, i + "");
        }

    }
}
