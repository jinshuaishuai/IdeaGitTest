package com.jin.drools.test;

import com.jin.drools.entity.ao.LevelAo;
import com.jin.drools.entity.dto.PersonDto;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
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
    public void testRuleName() {

        /*
            扫描resources/文件夹下的rules文件夹下的所有规则文件，找出规则名称为good的规则进行执行
            这种方式，可以指定某个规则执行。在实际开发中，指定了很多规则，肯定是让所有的规则都生效的，
            所以才有了方法fireAllRules，作为通用的组件，当然也提供了让具体的规则执行的方法。
         */
        AgendaFilter agendaFilter = new RuleNameEqualsAgendaFilter("nice");
        int i = kieSession.fireAllRules(agendaFilter);
        System.out.println(i);
    }

    @Test
    public void testExecuteAllRule() {
        /*
            所有的规则都会执行
         */
        int i = kieSession.fireAllRules();
        System.out.println(i);
    }

    @Test
    public void testAgendaFilter() {
        /*
            指定执行哪个规则，是以下标做开始的，每个规则被作为一个fireAllRules的参数，此时没法确定第几个规则是good
            第几个规则是helloworld
         */
        for (int k = 1;k <= 10; k++) {
            int i = kieSession.fireAllRules(k);
            System.out.println(i);
        }
    }

    @Test
    public void testRuleFact() {
        PersonDto personDto = new PersonDto();
        personDto.setAge(23);
        personDto.setName("zhangsan");
        System.out.println(personDto);

//        AgendaFilter agendaFilter = new RuleNameEqualsAgendaFilter("person-rule");

        //向规则文件中传入目标对象。
        kieSession.insert(personDto);
        int i = kieSession.fireAllRules(/*agendaFilter*/);
        System.out.println(personDto);
    }

    @Test
    public void testLevel() {
        LevelAo levelAo = new LevelAo();
        levelAo.setLevel(1);
        kieSession.insert(levelAo);

        /*AgendaFilter agendaFilter = new RuleNameEqualsAgendaFilter("level_rule");*/
        kieSession.fireAllRules(/*agendaFilter*/);
    }

    @Test
    public void testInteger() {
        Integer i1 = 1;
        System.out.println(i1.equals("1"));
    }

}
