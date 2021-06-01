package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author shuai.jin
 * @date 2021/5/12 10:55
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        new Thread(futureTask).start();

        String s = futureTask.get();
        boolean cancelled = futureTask.isCancelled();
        boolean done = futureTask.isDone();
        System.out.println(s);
        System.out.println(cancelled);
        System.out.println(done);

    }
    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("不见了远处的青山");
            return "success";
        }
    }
}
