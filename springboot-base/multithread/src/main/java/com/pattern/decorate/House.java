package com.pattern.decorate;

/**
 * @author shuai.jin
 * @date 2020/9/16 10:56
 */
public abstract class House {

    /**
        装饰设计模式：
            对现有类进行功能的增强，我的理解是，和代理模式差不多，代理模式不属于设计模式。
            现在是了解掌握了简单工厂，工厂方式，装饰，单例，开闭等设计模式，怎样把这些设计
            模式用到开发中
     */
    public void live() {
        System.out.println("房子是用来居住的");
    }
}
