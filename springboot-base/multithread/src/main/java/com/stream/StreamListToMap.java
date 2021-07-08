package com.stream;

import com.entity.domain.User;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Classname StreamListToMap
 * @Description TODO
 * @Date 2021/7/8 11:28
 * @Created by jinshuai
 */
public class StreamListToMap {

    public static void main(String[] args) {
        List<User> users =
                StreamTest.get();

        Map<Integer, User> collect = users.stream().collect(Collectors.toMap(User::getAge, Function.identity()));
        System.out.println(collect);
    }
}
