package com.pattern.decorate;

/**
 * @author shuai.jin
 * @date 2020/9/16 10:59
 */
public class RedHouse extends House {


    @Override
    public void live() {
        super.live();
        System.out.println("红房子");
    }
}
