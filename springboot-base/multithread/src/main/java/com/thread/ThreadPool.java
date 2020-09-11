package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shuai.jin
 * @date 2020/8/31 14:56
 */
public class ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5, 20, 1000,
                        TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行");
            }
        });
    }
}
