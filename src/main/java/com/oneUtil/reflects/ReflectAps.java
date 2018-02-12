package com.oneUtil.reflects;

import com.oneUtil.vos.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.*;

/**
 * Created by houyunjuan on 2018/2/12.
 */
public class ReflectAps {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Class<?> personClass = Class.forName(Person.class.getName());
        Person p = (Person) personClass.newInstance();//
        p.setAge(8);
        System.out.println(p.getAge());

        Constructor<?>[] constructors = personClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];
            String name = constructor.getName();
            System.out.println(name);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (null != parameterTypes && parameterTypes.length > 0) {
                for (Class<?> class1 : parameterTypes) {
                    System.out.println(class1);
                }
                Person newInstance = (Person) constructor.newInstance("zhangsan",9);
                System.out.println(newInstance);
            }
        }
    }
}
