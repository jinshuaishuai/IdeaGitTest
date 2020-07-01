package com.jin.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 向Spring容器中注入一个JedisPool对象，用于在JedisCacheUtil工具类中获取该类
 * 主要目的是：获取redis连接资源从连接池中获取，并且当连接使用完毕后，及时关闭资源，避免资源的浪费，
 * @author shuai.jin
 * @date 2020/5/27 17:53
 *
 */
@Configuration
@EnableCaching
@Slf4j
public class RedisConfig extends CachingConfigurerSupport {

	@Value("${spring.redis.host}")
    private String host;

	@Value("${spring.redis.port}")
    private int port;

	@Value("${spring.redis.password}")
	private String password;
	
	@Value("${spring.redis.timeout}")
    private int timeout;

	@Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;
	
	@Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;			

	@Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

	@Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Bean
    public JedisPool redisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMinIdle(minIdle);
        //有的redis有密码，有的没有密码，
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        log.info("JedisPool注入成功！host --->{} port --->{}", host, port);
        return  jedisPool;
    }


}