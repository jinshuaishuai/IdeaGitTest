package com.thread;

public class NotifyDemo {
    public static void main(String[] args) {
        final Printer p = new Printer();    //实例化一个对象
        new Thread() {    //采用匿名内部类的方式创建一个线程对象,并重写run方法,并开启线程.
            @Override
            public void run() {
                try {
                    p.print1();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    p.print2();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class Printer {
    private static int flag = 2;

    public void print1() throws InterruptedException {

        while (true) {
            if (flag == 2) {
                this.wait();
            } else {
                this.notify();
            }
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.println("员");

        }
    }

    public void print2() throws InterruptedException {
//		synchronized (this) {
        while (true) {
            if (flag == 1) {
                this.notify();
            } else {
                this.wait();
            }
            System.out.print("传");
            System.out.print("智");
            System.out.print("博");
            System.out.println("客");

        }
//		}
    }
}
