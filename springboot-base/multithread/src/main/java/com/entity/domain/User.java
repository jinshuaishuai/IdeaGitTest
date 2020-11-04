package com.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

/**
 * @author shuai.jin
 * @date 2020/10/9 13:32
 */
@Data
@AllArgsConstructor
public class User implements Serializable {

    private String name;

    private String address;

    private int age;

}
