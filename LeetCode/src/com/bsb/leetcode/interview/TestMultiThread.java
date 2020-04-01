package com.bsb.leetcode.interview;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-01 17:01
 */
public class TestMultiThread {

    final static Object object = new Object();
    static int i = 1;

    static class A extends Thread {

        @Override
        public void run() {
            synchronized (object) {

                for (i = 3; i < 100; i += 3) {
                    System.out.println(Thread.currentThread().getName() + "   " + i);
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class B extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                for (i = 1; i <= 100; i++) {
                    if (i % 3 == 0) {
                        object.notify();
                        try {
                            object.wait();
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "   " + i);
                }
                object.notify();
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        b.start();
        a.start();
    }
}
