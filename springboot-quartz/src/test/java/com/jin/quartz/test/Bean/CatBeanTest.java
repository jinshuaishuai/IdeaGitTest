package com.jin.quartz.test.Bean;

import com.jin.quartz.entity.bean.BeanConfiguration;
import com.jin.quartz.entity.bean.CatBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuai.jin
 * @date 2021/3/3 16:27
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class CatBeanTest {

   /* @Autowired
    private CatBean catBean;*/

   @Test
   public void testRefreshAndRegister() {
       AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

       ac.register(BeanConfiguration.class);
       ac.refresh();
       CatBean catBean = (CatBean) ac.getBean("catBean");

       System.out.println(catBean);
   }

    @Test
    public void testBeanGene() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        CatBean catBean = (CatBean) ac.getBean("catBean");
        System.out.println(catBean);

        String applicationName = ac.getApplicationName();

    }
}
