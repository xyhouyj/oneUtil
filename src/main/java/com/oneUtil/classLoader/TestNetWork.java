package com.oneUtil.classLoader;

import com.ehaoyao.qimen.models.Person;

/**
 * Created by houyunjuan on 2018/2/27.
 */
public class TestNetWork {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        NetworkClassLoader loader = new NetworkClassLoader("networkClassLoader");
        Class<?> clazz = loader.loadClass("com.ehaoyao.qimen.models.Person");
//        Class clazz = loader.findClass("Person");
        System.out.println(clazz);
        Person person = (Person) clazz.newInstance();

    }
}
