package com.jin.entity.domain;

/**
 * @author shuai.jin
 * @date 2020/8/17 9:40
 */
public class ThreadComm {

    public static volatile boolean flag = true;

    public static void main(String[] args) {
        for(int j = 0; j < 10; j++) {
            //演示线程间的通信：
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (this) {
                        while (!flag) {
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for(int i = 0;i < 5; i++) {
                            sayHello();
                        }
                        flag = false;
                        this.notify();
                    }

                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (this) {
                        while (flag) {
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        sayGoodBye();
                        flag = true;
                        this.notify();
                    }
                }
            }).start();
        }
    }

    public static void sayHello() {
        System.out.println("hello,world");
    }

    public static void sayGoodBye() {
        System.out.println("good bye");
    }

}
