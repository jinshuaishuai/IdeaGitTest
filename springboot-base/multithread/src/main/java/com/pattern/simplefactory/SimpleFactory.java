package com.pattern.simplefactory;

/**
 * @author shuai.jin
 * @date 2020/9/11 13:31
 */
public class SimpleFactory {

    public static Animal createAnimal(String args) {
        switch (args) {
            case "bird":
                return new Bird(args);
            case "dog":
                return new Dog(args);
            default:
                return new DefaultAnimal("default");
        }
    }

    public static void main(String[] args) {
        /*
            对简单工厂的总结：
            1、主要思想：其实这个思想很简单，简单工厂是为了生产类对象用的?显然不对吧，根据case情况不同
            创建具体的类的实例
            2、适应场景：
            3、优缺点：
         */

        Animal bird = SimpleFactory.createAnimal("dog");
        bird.eat();
        bird.sleep();
    }
}
