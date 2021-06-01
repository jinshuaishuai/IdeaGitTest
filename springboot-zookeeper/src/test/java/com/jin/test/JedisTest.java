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

}
