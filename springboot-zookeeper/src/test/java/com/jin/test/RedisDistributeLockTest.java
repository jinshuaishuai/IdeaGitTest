package com.jin.test;

import com.jin.config.lock.distributelock.RedisDistributeLock;
import com.jin.config.redis.JedisCacheUtil;
import com.jin.service.impl.OrderServiceImpl;
import com.jin.util.OrderNumberGeneratorUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author shuai.jin
 * @date 2020/6/30 11:09
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisDistributeLockTest {

    @Autowired
    private JedisCacheUtil jedisCacheUtil;

    @Test
    public void testRedisDistributeLock() throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            new Thread(new OrderServiceImpl(jedisCacheUtil)).start();
//            Thread.sleep(1000);
        }
    }

    @Test
    public void testInteger() {
        Integer i1 = 1;
        System.out.println(i1.equals(1));
    }
}
