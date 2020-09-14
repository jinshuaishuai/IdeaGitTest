package com.pattern.simplefactory;

/**
 * @author shuai.jin
 * @date 2020/9/11 13:38
 */
public class DefaultAnimal extends Animal {

    public DefaultAnimal(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " 吃饭");
    }

    @Override
    public void sleep() {
        System.out.println(name + " 睡觉");
    }
}