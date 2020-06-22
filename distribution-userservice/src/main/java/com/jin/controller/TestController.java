package com.jin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shuai.jin
 */
@RestController
@RequestMapping(value = "login")

public class TestController {
    @GetMapping(value = "/hello")
    public String hello(HttpServletRequest request) {
        return "success";
    }



}
