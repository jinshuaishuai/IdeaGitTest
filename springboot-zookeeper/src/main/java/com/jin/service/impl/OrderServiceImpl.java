package com.jin.service.impl;

import com.jin.config.lock.distributelock.DistributeLock;
import com.jin.config.lock.distributelock.RedisDistributeLock;
import com.jin.config.lock.distributelock.ZookeeperDistributeLock;
import com.jin.config.redis.JedisCacheUtil;
import com.jin.service.OrderService;
import com.jin.util.OrderNumberGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/4/20 17:25
 */
@Service
public class OrderServiceImpl implements OrderService {

    private DistributeLock distributeLock = new ZookeeperDistributeLock();

    public OrderServiceImpl(JedisCacheUtil jedisCacheUtil) {
        this.jedisCacheUtil = jedisCacheUtil;
    }

    private JedisCacheUtil jedisCacheUtil;

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
            getOrderNumberByRedis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getOrderNumberByRedis() {

        RedisDistributeLock lock = new RedisDistributeLock(jedisCacheUtil);
        String uuid = UUID.randomUUID().toString();
        try {
            boolean lockSuccess = lock.lock("abc", uuid, 1);
            if (lockSuccess) {
                System.out.println("加锁成功");
                String orderNumber = OrderNumberGeneratorUtil.getOrderNumber();
                System.out.println(orderNumber);
            } else {
                System.out.println("加锁失败");
            }
        } finally {
            boolean unlock = lock.unlock("abc", uuid);
            if (unlock) {
                System.out.println("释放锁成功");
                return;
            }
            System.out.println("释放锁失败");
        }
    }
}
