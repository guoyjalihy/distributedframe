package com.suyuan.rpc.registry.rmi;

import com.suyuan.rpc.server.rmi.HelloServiceRMI;
import com.suyuan.rpc.server.rmi.HelloServiceRMIImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIRegistry {
    public static void main(String[] args) throws Exception{
        HelloServiceRMI helloServiceRMI = new HelloServiceRMIImpl();
        LocateRegistry.createRegistry(8801);
        Naming.bind("rmi://localhost:8801/helloServiceRMI",helloServiceRMI);
        System.out.println("RMI server start...");
    }
}
