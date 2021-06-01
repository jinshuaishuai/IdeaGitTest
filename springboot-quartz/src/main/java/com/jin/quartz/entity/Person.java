package com.jin.quartz.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shuai.jin
 * @date 2020/8/21 11:26
 */
@Data
public class Person implements Serializable {

    private String name;

    private int age;

}
