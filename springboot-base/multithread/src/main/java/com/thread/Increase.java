package com.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shuai.jin
 * @date 2021/5/12 17:25
 */
public class Increase {
    /*private int num = 0;
    public synchronized void increase() {
        num++;
    }

    public int getNum() {
        return num;
    }*/

   /* private AtomicInteger num = new AtomicInteger(0);
    public void increase() {
        num.incrementAndGet();
    }
    public int getNum() {
        return num.get();
    }*/

    private int num = 0;
    private Lock lock = new ReentrantLock(true);
    public void increase() {
        lock.lock();
        try {
            num ++;
        }finally {
            lock.unlock();
        }
    }
    public int getNum() {
        return num;
    }

}
