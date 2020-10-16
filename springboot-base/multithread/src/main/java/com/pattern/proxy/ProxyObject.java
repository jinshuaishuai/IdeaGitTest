package com.pattern.proxy;

/**
 * @author shuai.jin
 * @date 2020/9/17 11:29
 */
public class ProxyObject implements ProxyInterface {

    ProxyInterface proxyInterface;

    ProxyObject(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    @Override
    public void building() {
        proxyInterface.building();
        //怀疑这是不是代码模式
        //代理模式和装饰模式的区别在哪？

        /*
            Today, dont't known what happend,no mind to write code
            bad things is,having lots of task to complete waiting me.
            but I can't calm down,what should i do

            in case of add interface,you should obtain a subclass from Animal
         */
        //对目标类进行增强
        System.out.println("此处添加业务逻辑");
    }

    public static void main(String[] args) {
        ProxyInterface proxyInterface = new TargetObject();

        ProxyObject proxyObject = new ProxyObject(proxyInterface);
        proxyObject.building();
    }
}
