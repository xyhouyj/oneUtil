package com.oneUtil.danli;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by houyunjuan on 2018/2/26.
 * 静态内部类的单例模式
 * 这种方式是Singleton类被装载了，instance不一定被初始化。
 * 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance
 */
public class StaticInnerSingleton implements Serializable{

    private static class SingletonHolder{
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }
    private StaticInnerSingleton(){}

    public static final StaticInnerSingleton getInstance(){
        return SingletonHolder.INSTANCE;
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
                    System.out.println(StaticInnerSingleton.getInstance().hashCode());
                }
            }.start();
        }
        latch.countDown();
    }
}
