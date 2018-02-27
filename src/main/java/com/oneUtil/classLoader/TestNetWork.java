package com.oneUtil.classLoader;

import com.ehaoyao.qimen.models.Person;

/**
 * Created by houyunjuan on 2018/2/27.
 */
public class TestNetWork {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        NetworkClassLoader loader = new NetworkClassLoader();
        Class clazz = loader.findClass("com.ehaoyao.qimen.models.Person");
        System.out.println(clazz);
        Person person = (Person) clazz.newInstance();

    }
}
