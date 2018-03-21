package com.oneUtil.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程对象实现类
 * 扩展UnicastRemoteObject  实现远程接口
 * Created by houyunjuan on 2018/3/21.
 */
public class RemoteInterfaceImpl extends UnicastRemoteObject implements RemoteInterface {
    //构造方法   抛出异常
    protected RemoteInterfaceImpl() throws RemoteException {
    }

    @Override
    public void sayHello() throws RemoteException {
        System.out.println("Hello World");
    }

    @Override
    public String helloSb(String sb) throws RemoteException {
        return "Hello" + sb;
    }
}
