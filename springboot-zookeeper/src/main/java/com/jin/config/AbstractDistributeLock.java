package com.jin.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shuai.jin
 * @description 抽象类分布式锁
 * @Date 2020/4/20 16:46
 */
@Slf4j
public abstract class AbstractDistributeLock implements DistributeLock {

    @Override
    public void getLock() throws Exception {
        if(tryLock()) {
            log.info("获取锁成功");
        } else {
            waitLock();         //等待锁
        }
    }

    /**
     * 等待锁
     */
    protected abstract void waitLock();

    public abstract boolean tryLock();
}
