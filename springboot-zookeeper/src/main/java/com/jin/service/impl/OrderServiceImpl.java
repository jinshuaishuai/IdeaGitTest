package com.jin.service.impl;

import com.jin.config.DistributeLock;
import com.jin.config.ZookeeperDistributeLock;
import com.jin.service.OrderService;
import com.jin.util.OrderNumberGeneratorUtil;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/4/20 17:25
 */
public class OrderServiceImpl implements OrderService {
    private DistributeLock distributeLock = new ZookeeperDistributeLock();
    @Override
    public String getOrderNumber() throws Exception {
        try {
            distributeLock.getLock();   //加锁
            String orderNumber = OrderNumberGeneratorUtil.getOrderNumber();
            System.out.println(Thread.currentThread().getName() + ":" + orderNumber);
            return orderNumber;
        } finally {
            distributeLock.unlock();
        }

    }

    @Override
    public void run() {
        try {
            getOrderNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
