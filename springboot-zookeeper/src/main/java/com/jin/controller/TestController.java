package com.jin.controller;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ZkClient zkClient;

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

    public static void main(String[] args) {
        System.out.println((14500 / 19) * 3);
    }
}
