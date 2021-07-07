package com.stream;

import com.entity.domain.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shuai.jin
 * @date 2020/9/17 18:53
 */
public class    StreamTest {



    static List<User> get() {
        return Arrays.asList(
                User.builder().name("zhangsan").age(23).address("河南郑州").status(0).build(),
                User.builder().name("lisi").age(24).address("河南周口").status(1).build(),
                User.builder().name("wangwu").age(25).address("陕西西安").status(1).build(),
                User.builder().name("zhaoliu").age(26).address("北京").status(0).build(),
                User.builder().name("liyajiao").age(27).address("陕西西安").status(0).build());
    }

    public static void main(String[] args) {


    }

   static int sort(User user1, User user2,int sortKey, int sortRule) {

        if(sortKey == 1) {
            //以姓名进行排序
            if(sortRule == 1) {
                return user1.getName().compareTo(user2.getName());
            } else {
                return user2.getName().compareTo(user1.getName());
            }
        } else if (sortKey == 2) {
            //以地址进行排序
            if(sortRule == 1) {
                return user1.getAddress().compareTo(user2.getAddress());
            } else {
                return user2.getAddress().compareTo(user1.getAddress());
            }
        } else {
            if(sortRule == 1) {
                return user1.getAge() - user2.getAge();
            } else {
                return user2.getAge() - user1.getAge();
            }
        }
    }

}
