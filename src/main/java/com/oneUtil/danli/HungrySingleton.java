package com.oneUtil.danli;

/**
 * Created by houyunjuan on 2018/2/26.
 * 饿汉
 */
public class HungrySingleton {
    //方式一
//类初始化的时候 自行实例化 staitc;并且不能被修改 final
    private static final HungrySingleton instanc = new HungrySingleton();

    //方式二
    private static HungrySingleton hungryTwo = null;
    static {
        hungryTwo = new HungrySingleton();
    }

    private HungrySingleton(){}

    public static HungrySingleton getInstanc(){
        return instanc;
    }
}
