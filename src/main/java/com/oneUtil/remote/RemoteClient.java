package com.oneUtil.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by houyunjuan on 2018/3/21.
 */
public class RemoteClient {
    public static void main(String[] args) {
        try {
            RemoteInterface remote = (RemoteInterface) Naming.lookup("rmi://localhost:8888/remoteObj");
            //调用远程方法
            remote.sayHello();
            System.out.println(remote.helloSb("duoduo"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
