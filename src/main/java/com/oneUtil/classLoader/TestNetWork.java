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
// * 一、ClassLoader加载类的顺序
//                *  1.调用 findLoadedClass(String) 来检查是否已经加载类。
//     *  2.在父类加载器上调用 loadClass 方法。如果父类加载器为 null，则使用虚拟机的内置类加载器。
//     *  3.调用 findClass(String) 方法查找类。
//     * 二、实现自己的类加载器
//                *  1.获取类的class文件的字节数组
//                *  2.将字节数组转换为Class类的实例
    }
}
