package com.jin.quartz.test.Bean;

import com.jin.quartz.entity.bean.DogBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuai.jin
 * @date 2021/3/3 14:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DogBeanTest {

    @Autowired
    private DogBean dogBean1;

    @Autowired
    private DogBean dogBean2;

    @Test
    public void testBeanPrototype() {
        System.out.println(dogBean1);
        System.out.println(dogBean2);
        System.out.println(dogBean2.getAge());
        System.out.println(dogBean1.getName());
    }
}
