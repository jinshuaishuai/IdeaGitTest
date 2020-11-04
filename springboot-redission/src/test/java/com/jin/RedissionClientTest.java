package com.jin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shuai.jin
 * @date 2020/11/3 13:28
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class RedissionClientTest {


    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void testRedssionClient() {
        RBucket<Object> test = redissonClient.getBucket("test");
        if(!test.isExists()) {
            test.set("好好学习", 1, TimeUnit.DAYS);
        }

        String s = test.get().toString();
        System.out.println(s);
    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<>();

        list.add("hello");

        list.add("good");

        RList<Object> list1 = redissonClient.getList("listTest");
        //怎样设置过期时间呢?


        if(!list1.isExists()) {
            list1.addAll(list);
        }
        list1.addAll(list);

        System.out.println(list1);

    }

    @Test
    public void testHash() {
        RMap<Object, Object> mapTest = redissonClient.getMap("mapTest");



        if(!mapTest.isExists()) {
           mapTest.put("hello", "hello");
           mapTest.put("world", "world");

           mapTest.put("nice", "nice");
        }

        System.out.println(redissonClient.getMap("mapTest"));
    }




}
