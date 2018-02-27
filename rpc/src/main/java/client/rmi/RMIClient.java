package client.rmi;

import server.rmi.HelloServiceRMI;

import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) throws Exception{
        System.out.println("RMI begin.");
        Long begin_time = System.currentTimeMillis();
        HelloServiceRMI helloServiceRMI = (HelloServiceRMI) Naming.lookup("rmi://localhost:8801/helloServiceRMI");
        String result = helloServiceRMI.hello("suyuan");
        System.out.println(result);
        System.out.println("RMI end.time:" + (System.currentTimeMillis() - begin_time) + "ms");
    }
}
