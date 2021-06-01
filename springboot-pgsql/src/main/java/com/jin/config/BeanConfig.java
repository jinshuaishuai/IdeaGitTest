package com.jin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author shuai.jin
 * @date 2021/1/21 15:29
 */
@Configuration
@Profile("test")
public class BeanConfig {

    @Value("${custom.car}")
    private String carName;

    @Bean
    public Car getCar() {

        return new Car(carName);
    }

    class Car {
        public Car(String carName) {
            System.out.println("自定义车:" + carName);
        }
    }
}
