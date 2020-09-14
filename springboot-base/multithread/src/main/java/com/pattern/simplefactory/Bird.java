package com.pattern.simplefactory;

/**
 * @author shuai.jin
 * @date 2020/9/11 13:33
 */
public class Bird extends Animal implements Fly{

    //飞行是一种行为，不光鸟具有飞行的功能，飞机，翼装飞行，鸡鸭都会飞

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " 吃饭");
    }

    @Override
    public void sleep() {
        System.out.println(name + "睡觉");
    }

    @Override
    public void fly() {
        //鸟具备飞行的行为
        //何不将看板中的那么多的条件搜索封装成一个或几个设计模式呢？

        System.out.println(name + " 飞行");
    }
}
