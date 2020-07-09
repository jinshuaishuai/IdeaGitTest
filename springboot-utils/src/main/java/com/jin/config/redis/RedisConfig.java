package com.jin.config.redis;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

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
@Data
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

}