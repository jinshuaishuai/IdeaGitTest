package com.jin.config.zookeeper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shuai.jin
 * @date 2021/4/29 14:22
 */
@Data
@Component
@ConfigurationProperties("zookeeper")
public class ZookeeperConfigProperties {

    private String url;

    private String defaultPath;

    private String port;
}
