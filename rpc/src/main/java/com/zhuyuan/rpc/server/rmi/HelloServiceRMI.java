package com.zhuyuan.rpc.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloServiceRMI extends Remote{
    String hello(String content) throws RemoteException;
}
