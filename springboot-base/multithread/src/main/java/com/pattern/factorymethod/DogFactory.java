package com.pattern.factorymethod;

import com.pattern.simplefactory.Animal;
import com.pattern.simplefactory.Dog;

/**
 * @author shuai.jin
 * @date 2020/9/11 16:20
 */
public class DogFactory implements FactoryMethod {

    public void init() {
        System.out.println("会默认执行吗，没加Spring的业务代码的情况下，答案很明显：不会执行");
    }

    @Override
    public Animal createAnimal() {
        return new Dog("dog");
    }

    public static void main(String[] args) {
        //这是面向对象中多态的直接体现

        FactoryMethod factoryMethod = new DogFactory();
        Animal animal = factoryMethod.createAnimal();
        animal.sleep();
        animal.eat();
        //这样也是不行啊，什么不行呢？你现在的任务是如何在看板模块用到设计模式，

        /*

         */
    }
}
