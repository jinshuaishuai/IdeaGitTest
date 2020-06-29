package com.jin.controller;

import com.jin.service.OrderService;
import com.jin.service.impl.OrderServiceImpl;

import javax.lang.model.element.NestingKind;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/4/20 17:35
 */
public class OrderController {


    public static void main(String[] args) throws Exception {
        //创建100个线程。
        for(int i = 0;i < 3000; i++) {
            new Thread(new OrderServiceImpl()).start();
        }
    }
}
