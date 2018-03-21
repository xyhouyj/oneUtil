package com.oneUtil.remote;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by houyunjuan on 2018/3/21.
 */
public class RemoteServer {
    public static void main(String[] args) {
        try {
            //远程接口
            RemoteInterface remoteObj = new RemoteInterfaceImpl();
            //远程服务 注册 监听8888端口 jvm默认是1099
            LocateRegistry.createRegistry(8888);
            //注册服务
            try {
                Naming.bind("rmi://localhost:8888/remoteObj",remoteObj);
                System.out.println("注册远程服务成功");
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
