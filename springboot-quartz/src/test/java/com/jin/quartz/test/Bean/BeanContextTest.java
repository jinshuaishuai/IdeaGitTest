package com.jin.quartz.test.Bean;

import com.jin.quartz.entity.bean.BeanConfiguration;
import com.jin.quartz.entity.bean.CatBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author shuai.jin
 * @date 2021/3/4 10:08
 */
@RunWith(SpringJUnit4ClassRunner.class)

//用于创建Spring的应用程序的上下文
@ContextConfiguration(classes = BeanConfiguration.class)
public class BeanContextTest {

    @Autowired
    private CatBean catBean;

    @Test
    public void testBean() {
        catBean.age = 23;
        catBean.name = "张三";

    }
}
