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
        List<User> list = new ArrayList<>();
        User fengqi = User.builder()
                .name("fengqi")
                .age(2)
                .address("")
                .build();
        list.add(fengqi);
        User lisi = User.builder()
                .name("lisi")
                .address("789")
                .age(33)
                .build();
        list.add(lisi);

        User wangwu = User.builder()
                .name("wangwu")
                .address("234")
                .age(24)
                .build();
        list.add(wangwu);
        User wangwu1 = User.builder()
                .name("wangwu")
                .address("234")
                .age(25)
                .build();
        list.add(wangwu1);

        User wangwu2 = User.builder()
                .name("wangwu")
                .address("567")
                .age(25)
                .build();
        list.add(wangwu2);

        User zhangsan = User.builder()
                .name("zhangsan")
                .age(23)
                .address("1211")
                .build();
        list.add(zhangsan);
        User zhangsan1 = User.builder()
                .name("zhangsan")
                .age(24)
                .address("234")
                .build();
        list.add(zhangsan1);

        //此处进行分组表数据的分组设置

        double sum = list.stream().mapToDouble(user -> user.getAge()).sum();
        System.out.println(sum);
        OptionalDouble average = list.stream().mapToDouble(User::getAge).average();
        System.out.println(average.getAsDouble());
        OptionalDouble min = list.stream().mapToDouble(User::getAge).min();
        System.out.println(min.getAsDouble());
        OptionalDouble max = list.stream().mapToDouble(User::getAge).max();
        System.out.println(max.getAsDouble());
        long count = list.stream().distinct().count();
        System.out.println(count);

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
