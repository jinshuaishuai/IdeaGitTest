package com.stream;

import com.entity.domain.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Classname StreamMapTest
 * @Description TODO
 * @Date 2021/7/6 11:40
 * @Created by jinshuai
 */
public class StreamMapTest {

    public static void main(String[] args) {
        List<User> users = StreamTest.get();
        List<Integer> collect = users.stream().map(User::getAge).collect(Collectors.toList());
        List<Integer> collect1 = collect.stream().filter(result -> {
            return result > 25;
        }).collect(Collectors.toList());

        System.out.println(collect1);


        //找出年龄大于25的所有人

        List<User> collect2 = users.stream().filter(user -> {
            return user.getAge() > 25;
        }).collect(Collectors.toList());
        System.out.println(collect2);

        //找出名字叫wangwu的人
        List<User> collect3 = users.stream().filter(user -> {
            return "wangwu".equals(user.getName());
        }).collect(Collectors.toList());
        System.out.println(collect3);

        //是不是可以只取出三列的值呢:答案是不可以
//        users.stream().map(User::getName).map(User::getAddress).map(User::getAge).collect(Collectors.toList());


        //将所有人的年龄都转为字符串,然后再转为int类型值
        List<Integer> collect4 =
                users.stream()
                        .map(User::getAge)
                        .map(String::valueOf)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
        System.out.println(collect4);

    }
}
