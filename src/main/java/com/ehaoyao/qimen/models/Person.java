package com.ehaoyao.qimen.models;

public class Person {

    private  String name;

    private  Integer age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    static {
        System.out.println("测试执行");
    }
}
