package com.jin.entity.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author shuai.jin
 * @date 2020/12/16 17:43
 */
@Component
public class BeanLifecycle implements BeanNameAware, BeanFactoryAware,BeanFactoryPostProcessor, InitializingBean {

    @Autowired
    private BeanFactory beanFactory;

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("执行了吗");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private BeanLifecycle() {
        System.out.println("无参构造方法执行");
    }



    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware的实现方法执行");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor接口的实现方法执行");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware接口的实现方法");

    }


    @Override
    public String toString() {
        return "BeanLifecycle{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口的实现方法执行");
        Object bean = beanFactory.getBean("beanLifecycle");
        if(bean instanceof BeanLifecycle) {
            BeanLifecycle a = (BeanLifecycle) bean;
        }

    }
}
