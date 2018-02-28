package com.zhuyuan.rpc.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceRMIImpl extends UnicastRemoteObject implements HelloServiceRMI {
    public HelloServiceRMIImpl() throws RemoteException {
        super();
    }

    @Override
    public String hello(String content){
        return "hello " + content;
    }
}
