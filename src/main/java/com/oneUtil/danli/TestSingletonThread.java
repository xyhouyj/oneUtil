package com.oneUtil.danli;

import java.util.concurrent.CountDownLatch;

/**
 * Created by houyunjuan on 2018/2/26.
 */
public class TestSingletonThread {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        int threadCount = 100;

        for (int i = 0; i < threadCount; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(LazySingleton.getInstance().hashCode());
                }
            }.start();
        }
        latch.countDown();
//        LazySingleton lazy1 = LazySingleton.getInstance();
//        LazySingleton lazy2 = LazySingleton.getInstance();
//        System.out.println(lazy1 == lazy2);
    }
}
