package com.jin.drools.controller;

import com.jin.drools.entity.ao.LevelAo;
import com.jin.drools.entity.dto.PersonDto;
import com.jin.drools.entity.dto.ResultDto;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuai.jin
 * @date 2020/7/21 17:27
 */
@RestController
public class TestController {

    @Autowired
    private KieSession kieSession;

    @GetMapping(value = "getRule")
    public void getRule(@RequestParam String rule) {
        AgendaFilter agendaFilter = new RuleNameEqualsAgendaFilter(rule);
        kieSession.fireAllRules(agendaFilter);

        System.out.println("怎么不执行了？");
    }

    @GetMapping(value = "getLevel")
    public ResultDto getLevel(@RequestParam int level) {
        LevelAo levelAo = new LevelAo();
        levelAo.setLevel(level);

        ResultDto resultDto = new ResultDto();
        kieSession.insert(levelAo);
        kieSession.insert(resultDto);
        kieSession.fireAllRules();
        return resultDto;
    }
}
