package com.jin.config;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname ZookeeperConfiguration
 * @Description zookeeper配置类
 * @Date 2021/6/30 14:12
 * @Created by jinshuai
 */
@Configuration
public class ZookeeperConfiguration {

//    @Bean
    public ZkClient zkClient() {
        String connectUrl = "localhost:2181";
        ZkClient zkClient = new ZkClient(connectUrl);
        return zkClient;
    }
}
