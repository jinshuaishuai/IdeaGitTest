package com.jin.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author shuai.jin
 * @date 2020/7/2 16:06
 */
@Slf4j
@Configuration
public class RedisConfiguration {

    @Autowired
    private RedisConfig redisConfig;
    @Bean
    public JedisPool redisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
        jedisPoolConfig.setMaxTotal(redisConfig.getMaxActive());
        jedisPoolConfig.setMinIdle(redisConfig.getMinIdle());
        //有的redis有密码，有的没有密码，
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisConfig.getHost(),
                redisConfig.getPort(), redisConfig.getTimeout(), redisConfig.getPassword());
        log.info("JedisPool注入成功！host --->{} port --->{}", redisConfig.getHost(), redisConfig.getPort());
        return  jedisPool;
    }
}
