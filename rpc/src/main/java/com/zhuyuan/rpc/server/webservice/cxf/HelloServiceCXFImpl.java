package com.zhuyuan.rpc.server.webservice.cxf;

import javax.jws.WebService;

@WebService(endpointInterface = "com.zhuyuan.rpc.server.webservice.cxf.HelloServiceCXF")
public class HelloServiceCXFImpl implements HelloServiceCXF {
    public String hello(String content) {
        return "hello " + content;
    }
}
