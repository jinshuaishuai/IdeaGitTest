package com.jin.quartz.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author shuai.jin
 * @date 2020/7/29 11:41
 */
@Component
public class NormalScheduleTask {

//    @Scheduled(cron = "0/10 * * * * *")
    public void sayHello() {
        System.out.println("hello,world");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> forName = Class.forName("com.jin.GoogleAuthenticatorUtil");

        System.out.println(forName.getPackage().getName());
        System.out.println(forName);
    }
}
