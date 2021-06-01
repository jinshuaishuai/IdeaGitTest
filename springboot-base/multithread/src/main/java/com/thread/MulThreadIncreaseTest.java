package com.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shuai.jin
 * @date 2021/5/12 17:26
 */
public class MulThreadIncreaseTest {
    public static void main(String[] args) throws InterruptedException {

        Increase increase = new Increase();
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000000; i++) {
                    increase.increase();

                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000000; i++) {
                    increase.increase();
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(increase.getNum());
        long endTime = System.currentTimeMillis();
        System.out.println("用时：------>"+ (endTime - startTime));
    }
}
