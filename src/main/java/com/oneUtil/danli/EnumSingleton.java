package com.oneUtil.danli;


/**
 * Created by houyunjuan on 2018/2/26.
 * 枚举单例 它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
public enum EnumSingleton {
    INSTANCE;

    public void whateverMethod(){

    }
}
