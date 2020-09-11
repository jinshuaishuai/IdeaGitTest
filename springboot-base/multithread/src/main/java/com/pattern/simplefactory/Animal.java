package com.pattern.simplefactory;

/**
 * @author shuai.jin
 * @date 2020/9/11 13:31
 */
public abstract class Animal {

    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();

    public abstract void sleep();
}
