package com.jin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author shuai.jin
 * @date 2020/6/20 6:35
 */
@SpringBootApplication
@EnableScheduling
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(basePackages = "com.jin.mapper.**")
public class PointServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PointServiceApplication.class, args);
    }
}
