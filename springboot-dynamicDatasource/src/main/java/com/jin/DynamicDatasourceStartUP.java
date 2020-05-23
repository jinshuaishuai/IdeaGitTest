package com.jin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/19 14:42
 */
@SpringBootApplication
@MapperScan(basePackages = "com.jin.mapper.**")
public class DynamicDatasourceStartUP {
    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceStartUP.class, args);
    }
}
