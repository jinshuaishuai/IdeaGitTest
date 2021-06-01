package com.jin.config.lock.distributelock;

import com.jin.config.redis.JedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 利用redis实现分布式锁
 * @author shuai.jin
 * @date 2020/6/30 9:30
 */
@Component
public class RedisDistributeLock extends AbstractDistributeLock {

    /**
       加锁成功标识
     */
    private static final String LOCK_SUCCESS = "OK";

    /**
     * 过期时间单位 S
     */
    private static final String EXPIRE_UNIT_EX = "EX";

    /**
     * 释放锁
     */
    private static final String RELEASE_SUCCESS = "OK";
    /**
     * 默认的过期时间 60秒
     */
    private static final int DEFAULT_EXPIRE_TIME_EX = 60;

    /**
     * 过期时间单位 毫秒
     */
    private static final String EXPIRE_UNIT_PX = "PX";

    /**
     * 过期时间 500毫秒
     */
    private static final long DEFAULT_EXPIRE_TIME_PX = 500;

    private JedisCacheUtil jedisCacheUtil;


    public RedisDistributeLock(JedisCacheUtil jedisCacheUtil) {
        this.jedisCacheUtil = jedisCacheUtil;
    }

    @Override
    protected void waitLock() {

    }

    @Override
    public boolean tryLock() {
        /*
            获取锁的思路：利用redis的setnx方法，如果设置值成功，返回1，根据1判断是否获取了锁，返回1，就表示获得了锁
            获得锁之后，要设置该锁的过期时间，
         */
        return false;
    }

    @Override
    public void unlock() {

    }

    /**
     * 加锁
     * @param lockKey           锁名称
     * @param requestId         是否是锁唯一标识
     * @param expireTime        锁的过期时间
     * @return                  加锁成功返回 true 失败返回 false
     */
    public boolean lock(String lockKey, String requestId, int expireTime) {
        String ex = jedisCacheUtil.set(lockKey, requestId,EXPIRE_UNIT_EX, "", expireTime);
        synchronized (this) {
            if(LOCK_SUCCESS.equals(ex)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean unlock(String lockKey, String requestId) {
        String value = jedisCacheUtil.get(lockKey, 2);
        if(!StringUtils.isEmpty(value)) {
            synchronized (this) {
                if(requestId.equals(value)) {
                    //删除锁
                    jedisCacheUtil.del(2, requestId);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
