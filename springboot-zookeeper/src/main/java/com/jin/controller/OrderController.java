package com.jin.controller;

import com.jin.service.OrderService;
import com.jin.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.NestingKind;
import java.util.Hashtable;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/4/20 17:35
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/getOrderNum")
    public String getOrderNum() throws Exception {
        return orderService.getOrderNumber();
    }

    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("age", 1);
        hashtable.put("age", 2);


    }


}
