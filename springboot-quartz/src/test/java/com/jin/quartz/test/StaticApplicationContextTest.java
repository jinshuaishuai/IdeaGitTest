package com.jin.quartz.test;

import com.jin.quartz.entity.bean.CatBean;
import org.junit.Test;
import org.springframework.context.support.StaticApplicationContext;

/**
 * @author shuai.jin
 * @date 2021/3/24 16:56
 */
public class StaticApplicationContextTest {

    @Test
    public void testRegisterBean() {
        StaticApplicationContext sa = new StaticApplicationContext();
        sa.registerSingleton("catProxy", CatBean.class);
        sa.refresh();

        CatBean catProxy = (CatBean) sa.getBean("catProxy");

        System.out.println(catProxy);
    }
}
