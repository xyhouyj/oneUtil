package com.oneUtil.classLoader;

/**
 * Created by houyunjuan on 2018/2/27.
 */
public class Test2 {
    static {
        System.out.println("静态初始块执行了");
    }
    public void print(){
        System.out.println("方法一");
    }
}
