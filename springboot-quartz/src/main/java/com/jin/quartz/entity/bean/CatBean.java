package com.jin.quartz.entity.bean;

import com.jin.quartz.entity.Animal;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author shuai.jin
 * @date 2021/3/3 15:07
 */

@Data
public class CatBean extends Animal implements InitializingBean, DisposableBean {
    void init() {
        System.out.println("init...");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet方法调用");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁方法执行");
    }
}
