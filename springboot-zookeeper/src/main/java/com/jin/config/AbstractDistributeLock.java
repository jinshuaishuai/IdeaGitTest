package com.jin.config;

/**
 * @author shuai.jin
 * @description 抽象类分布式锁
 * @Date 2020/4/20 16:46
 */
public abstract class AbstractDistributeLock implements DistributeLock {

    @Override
    public void getLock() throws Exception {
        if(tryLock()) {
            System.out.println("获取锁成功");
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
