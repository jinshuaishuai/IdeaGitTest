package com.jin.config.beanconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuai.jin
 * @date 2020/6/28 9:48
 */
@Configuration
public class LoadBalancerConfiguration {
    @Bean
    public IRule iRule() {
        return new ZoneAvoidanceRule();
    }
}
