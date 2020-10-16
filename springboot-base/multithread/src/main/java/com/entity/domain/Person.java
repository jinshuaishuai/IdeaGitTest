package com.entity.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

/**
 * @author shuai.jin
 * @date 2020/10/9 13:32
 */
@Data
public class Person implements Serializable {

    private String name;

    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    public int getHashCode() {
        return Objects.hashCode(13);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        for(int j = 0; j < 100; j++) {
            System.out.println(getRangeValue(7, 15));
        }

    }

    public static int getRangeValue(int min, int max) {
        Double value = Math.random() * (min + 1) + (max - min);
        return value.intValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
