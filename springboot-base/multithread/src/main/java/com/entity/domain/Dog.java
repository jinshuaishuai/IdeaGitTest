package com.entity.domain;

import lombok.Data;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2021/1/11 15:37
 */
@Data
public class Dog implements Comparable<Dog> {

    private String name;

    private Integer age;

    private Object id;

    private List<String> abc;


    @Override
    public int compareTo(Dog dog) {
        if(dog.getName().equals(this.name) && dog.getAge().equals(this.age) && dog.getId().equals(this.id)) {
            return 0;
        } else {
            return 1;
        }
    }
}
