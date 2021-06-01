package com.jin.quartz.entity.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author shuai.jin
 * @date 2021/3/3 14:09
 */
@Configuration
public class BeanConfiguration {

    @Bean(initMethod = "init")
    @Lazy
    public CatBean catBean() {

        return new CatBean();
    }
}
