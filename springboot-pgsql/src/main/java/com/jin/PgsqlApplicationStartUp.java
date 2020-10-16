package com.jin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 13:51
 */
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.jin.mapper.**")
public class PgsqlApplicationStartUp {
    public static void main(String[] args) {
        SpringApplication.run(PgsqlApplicationStartUp.class, args);
    }
}
