package com.jin.quartz.entity.bean;

import com.jin.quartz.entity.Person;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author shuai.jin
 * @date 2021/4/6 11:32
 */
public class PersonTest {

    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>();
        Person person1 = new Person();
        person1.setName("1");
        person1.setAge(23);

        Person person2 = new Person();
        person2.setAge(23);
        person2.setName("1");

        set.add(person1);
        set.add(person2);
        System.out.println(set.size());
    }
}
