package com.entity.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author shuai.jin
 * @date 2020/11/16 14:48
 */

public class Person implements Serializable {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        if(name == null) {
            return 0;
        }
        if(name.equals("zhangsan")) {
            return 1;
        }
        return 2;
    }
}
