package com.stream;

import com.entity.domain.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shuai.jin
 * @date 2020/10/29 15:41
 */
public class StreamGroupBy {

    public static void main(String[] args) {
        String s = "abc$$123";
        String[] $$s = s.split("$$");
        for(String str : $$s) {
            System.out.println(str);
        }

    }

    private static void test1() {
       /* User user1 = new User("zhangsan", "beijing", 10);
        User user2 = new User("zhangsan", "beijing", 20);
        User user3 = new User("lisi", "shanghai", 30);
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        List<User> collect = list.stream().filter(user -> user.getAge() > 10).collect(Collectors.toList());

        System.out.println(collect);*/
    }

    private static String fetchGroupKey(User user){
        return user.getName() +"#"+ user.getAddress() + "#分组1";
    }

}
