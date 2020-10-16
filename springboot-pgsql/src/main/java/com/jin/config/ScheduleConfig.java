package com.jin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * @author shuai.jin
 * @date 2020/9/17 16:08
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(5));
    }


    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
