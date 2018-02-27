package com.oneUtil.classLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by houyunjuan on 2018/2/27.
 */
public class MyClassLoader {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL url = new URL("file:/D:\\installsofts\\git\\gitworkspace\\target\\classes\\com\\oneUtil\\classLoader");
        ClassLoader myloader = new URLClassLoader(new URL[]{url});
        Class c = myloader.loadClass("com.oneUtil.classLoader.Test2");
        System.out.println("----------");
        Test2 t3 = (Test2) c.newInstance();
    }
}
