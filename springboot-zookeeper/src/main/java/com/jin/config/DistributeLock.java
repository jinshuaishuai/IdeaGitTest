package com.jin.config;

/**
 * @author shuai.jin
 * @description 分布式锁接口，可以有多个实现方式：例如，Zookeeper，Redis或Redission等
 * @Date 2020/04/20 16:26
 */
public interface DistributeLock {
    /**
     * 获取锁
     * @throws Exception
     */
    public void getLock() throws Exception;

    /**
     * 释放锁
     */
    public void unlock();
}
