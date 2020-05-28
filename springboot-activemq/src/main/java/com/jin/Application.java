package com.jin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author jinshuai
 * @description 项目启动类
 */
@SpringBootApplication
@EnableJms
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
