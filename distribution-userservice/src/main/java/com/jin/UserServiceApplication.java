package com.jin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shuai.jin
 * @date 2020/6/9 10:37
 */
@SpringBootApplication
@EnableScheduling
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@MapperScan(basePackages = "com.jin.mapper.**")
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
