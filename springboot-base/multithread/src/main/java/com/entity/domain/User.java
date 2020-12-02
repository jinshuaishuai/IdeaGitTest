package com.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

/**
 * @author shuai.jin
 * @date 2020/10/9 13:32
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User implements Serializable {

    private String name;

    private String address;

    private int age;

    private Integer status;

    public static void main(String[] args) {
        Long l = 3L;
        Integer i = 1;
        System.out.println(l.equals(3));
        System.out.println(i.equals(l));

        System.out.println(l.compareTo(3L));
    }



}
