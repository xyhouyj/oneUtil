package com.oneUtil.danli;

import java.util.concurrent.CountDownLatch;

/**
 * Created by houyunjuan on 2018/2/26.
 * 懒汉单例模式 在第一次被调用的时候 实例化
 */
public class LazySingleton {


    private static LazySingleton instance = null;
    private LazySingleton(){}

   /* public synchronized static LazySingleton getInstance(){
        if (null == instance){
            instance = new LazySingleton();
        }
        return instance;
    }*/
    //添加synchronized之后 可在多线程下工作
    public synchronized static LazySingleton getInstance(){
        if (null == instance){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }


}
