package com.jin.service;

/**
 * @author shuai.jin
 * @Date    2020/4/20 17:24
 */
public interface OrderService extends Runnable {

    /**
     * 生成订单号
     * @return
     */
    public String getOrderNumber() throws Exception;
}
