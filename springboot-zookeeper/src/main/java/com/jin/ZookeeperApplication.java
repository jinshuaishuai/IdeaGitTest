package com.jin;

import com.jin.config.zookeeper.ZookeeperConfigProperties;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

/**
 * @author shuai.jin
 * @description Zookeeper实现分布式锁
 * @Date 2020/4/20 15:21
 */
@SpringBootApplication
public class ZookeeperApplication implements ApplicationRunner {

    @Autowired
    private ZkClient zkClient;

    @Autowired
    private ZookeeperConfigProperties properties;

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //在项目启动时，向zookeeper中创建一个临时节点

        String hostAddress = System.getenv("bi_server_zsxj");
        if(StringUtils.isEmpty(hostAddress)) {
            hostAddress = "bi_server_zsxj";
        }
        zkClient.createPersistent(properties.getDefaultPath());

        String path = properties.getDefaultPath() + "/" + hostAddress;

        zkClient.createEphemeral(path);
    }
}
