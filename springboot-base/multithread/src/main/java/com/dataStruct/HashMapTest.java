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

        HashMap<Person, Integer> map = new HashMap<>();
        for(int i = 0; i < 100; i++) {
            map.put(new Person(String.valueOf(i), i), i);
        }


    }
}
