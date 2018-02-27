package com.oneUtil.classLoader;

/**
 * Created by houyunjuan on 2018/2/27.
 */
public class TestHelo {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        ClassLoader loader = TestHelo.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        //loadClass方法底层调用protected Class<?> loadClass(String name, boolean resolve)  resolve =false
        loader.loadClass("com.oneUtil.classLoader.Test2");
        //使用Class.forName()来加载类，默认会执行初始化块
                Class.forName("com.oneUtil.classLoader.Test2");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
                Class.forName("com.oneUtil.classLoader.Test2", false, loader);
    }

}
