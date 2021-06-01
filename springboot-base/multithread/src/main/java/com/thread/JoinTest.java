package com.thread;

/**
 * @author shuai.jin
 * @date 2021/5/12 15:27
 */
public class JoinTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}
