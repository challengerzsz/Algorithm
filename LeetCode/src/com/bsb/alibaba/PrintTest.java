package com.bsb.alibaba;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-17 22:29
 */

public class PrintTest {

    static class ThreeThread extends Thread {

        private Object obj;

        public ThreeThread(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            for (int i = 3; i < 100; i += 3) {
                synchronized (obj) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        }
    }

    static class FiveThread extends Thread {

        private Object obj;

        public FiveThread(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            for (int i = 5; i < 100; i += 5) {
                synchronized (obj) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {

        Object threeObj = new Object();
        Object fiveObj = new Object();

        ThreeThread three = new ThreeThread(threeObj);
        FiveThread five = new FiveThread(fiveObj);

        three.start();
        five.start();

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                synchronized (threeObj) {
                    threeObj.notify();
                }
                Thread.yield();
                continue;
            }

            if (i % 5 == 0) {
                synchronized (fiveObj) {
                    fiveObj.notify();
                }
                Thread.yield();
                continue;
            }

            System.out.println(i);
        }
    }
}