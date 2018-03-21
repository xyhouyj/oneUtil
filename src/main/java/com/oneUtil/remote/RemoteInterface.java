package com.oneUtil.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义远程接口 扩展Remote
 * 定义方法 public  抛出RemoteException
 * Created by houyunjuan on 2018/3/21.
 */
public interface RemoteInterface extends Remote {

    public void sayHello() throws RemoteException;

    public String helloSb(String sb) throws RemoteException;
}
