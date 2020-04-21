package com.jin;

import com.jin.config.ZookeeperDistributeLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author shuai.jin
 * @description Zookeeper实现分布式锁
 * @Date 2020/4/20 15:21
 */
@SpringBootApplication
public class ZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperApplication.class, args);
    }
}
