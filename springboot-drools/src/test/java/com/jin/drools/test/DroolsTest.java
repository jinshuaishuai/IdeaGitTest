package com.jin.drools.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuai.jin
 * @date 2020/7/21 15:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DroolsTest {

    @Autowired
    private KieSession kieSession;

    @Test
    public void testKieSession() {
        int i = kieSession.fireAllRules();

        System.out.println(i);
    }

}
