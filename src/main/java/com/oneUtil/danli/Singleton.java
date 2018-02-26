package com.oneUtil.danli;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by houyunjuan on 2018/2/26.
 * 双重校验锁的单例模式
 */
public class Singleton implements Serializable{
    private static volatile  Singleton instance = null;

    //私有构造方法
    private Singleton(){}

    public static Singleton getSingleton(){
//        synchronized (Singleton.class){
            if (instance == null) {
                synchronized (Singleton.class){
                    if (null == instance){
                        instance = new Singleton();
                    }
                }
            }
//        }
        return instance;
    }

    private Object readResolve(){
        return instance;
    }

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        int thread = 100;
        for(int i = 0;i<thread;i++){
            new Thread(){
                @Override
                public void run() {
                        try {
                            latch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Singleton.getSingleton().hashCode());
                }
            }.start();
        }
        latch.countDown();

//       Singleton instance = Singleton.getSingleton();
//       Singleton ins = Singleton.getSingleton();
//        System.out.println(instance == ins);
//        System.out.println(ins.hashCode() == instance.hashCode());
    }
}
