package com.pattern.proxy;

/**
 * @author shuai.jin
 * @date 2020/9/17 11:28
 */
public class TargetObject implements ProxyInterface {

    @Override
    public void building() {
        System.out.println("I am target class");
    }
}
