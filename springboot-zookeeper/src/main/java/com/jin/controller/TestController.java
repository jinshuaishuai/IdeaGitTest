package com.jin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/4/22 15:38
 */
@RestController
public class TestController {

    @GetMapping(value = "/hello")
    public String hello(@RequestParam List<String> strs) {
        List<String> strings = new ArrayList<>();
        if(strs != null && strs.size() > 0) {
            strs.forEach(str -> {
                strings.add(str);
            });
        }
        return strings.toString();
    }
    @GetMapping(value = "sayHello")
    public String sayHello(@RequestParam String str) {
        System.out.println(str);
        return str + "响应成功";
    }
}
