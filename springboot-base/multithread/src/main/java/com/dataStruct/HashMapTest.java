package com.dataStruct;

import com.entity.domain.Person;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author shuai.jin
 * @date 2020/11/16 9:48
 */
public class HashMapTest {

    public static void main(String[] args) {

//        method1();
        HashMap<String, Integer> map = new HashMap<>();
        Integer x = map.put("x", 1);
        Integer y = map.put("y", 1);
        Integer x1 = map.put("x", 2);
        System.out.println(x);
        System.out.println(y);
        System.out.println(x1);

    }

    private static void method1() {
        HashMap<Person, Integer> map = new HashMap<>();
        for(int i = 0; i < 100; i++) {
            map.put(new Person(String.valueOf(i), i), i);
        }
    }

    private static void method2() {
        HashMap<String, String> map = new HashMap<>(20,0.75f);
    }
}
