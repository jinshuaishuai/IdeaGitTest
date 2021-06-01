package com.jin.config.zookeeper;

import lombok.Data;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuai.jin
 * @date 2021/4/28 17:59
 */
@Configuration
public class ZookeeperConfiguration {

    @Autowired
    private ZookeeperConfigProperties properties;


    @Bean
    public ZkClient zkClient() {

        //获取服务端的连接url
        String connectUrl = properties.getUrl() + ":" + properties.getPort();
        ZkClient zkClient = new ZkClient(connectUrl);





        return zkClient;
    }
}
