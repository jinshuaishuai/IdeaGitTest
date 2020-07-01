package com.jin.test;

import com.jin.config.redis.JedisCacheUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuai.jin
 * @date 2020/6/30 9:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JedisTest {

    @Autowired
    private JedisCacheUtil jedisCacheUtil;

    @Test
    public void testSet() throws InterruptedException {
        String set1 = jedisCacheUtil.set("good", "goods", "px", 5000, 2);
       for(int i = 0;i < 40;i++) {
           Long good = jedisCacheUtil.ttl("good", 2);
           String good1 = jedisCacheUtil.get("good", 2);
           System.out.println("剩余过期时间为：------> " + good + " 目标数据的值为：------> " + good1);
           Thread.sleep(1000);
       }


    }

    @Test
    public void testSetEx() {
        String ex = jedisCacheUtil.set("age", "23", "EX", 60, 2);
        System.out.println(ex);
    }
}
