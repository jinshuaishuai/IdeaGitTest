package com.jin;

import org.I0Itec.zkclient.ZkClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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
public class PgsqlApplicationStartUp implements ApplicationRunner {

    /*@Autowired
    private ZkClient zkClient;*/

    public static void main(String[] args) {
        SpringApplication.run(PgsqlApplicationStartUp.class, args);
    }


    /**
     * 这个方法是实现于ApplicationRuuner接口的，目的是在项目启动之前，将服务实例注册到
     * zookeeper上
     */

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //项目启动的时候，向zookeeper上，写入实例信息
        /*if(!zkClient.exists("/test")) {
            zkClient.createPersistent("/test");
        }

        zkClient.createEphemeral("/test" + "/" + "pgsqlApplicationStartUp");
    */
    }
}
