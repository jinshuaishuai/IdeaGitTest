package com.example.aop;

import com.example.extendsTest.Animal;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname Dog
 * @Description TODO
 * @Date 2021/7/7 14:06
 * @Created by jinshuai
 */
@Getter
@Setter
public class Dog extends Animal {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("hello");
        System.out.println(dog);
    }
}
