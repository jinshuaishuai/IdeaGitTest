package com.jin.quartz.entity;

import lombok.Data;

/**
 * @author shuai.jin
 * @date 2021/3/3 15:08
 */
@Data
public abstract class Animal {

     public String name;

     public Integer age;

    /**
     * 包级别私有的，和目标接口或类在同一个包中的类或接口可以获取到被包级私有修饰符修饰的成员。即便是
     * 其子类，但该子类不与目标成员在同一个包中，无法访问成员。这就是包级别私有
     */

}
