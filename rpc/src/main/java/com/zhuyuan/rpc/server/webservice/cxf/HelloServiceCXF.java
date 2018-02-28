package com.zhuyuan.rpc.server.webservice.cxf;

import javax.jws.WebService;

@WebService
public interface HelloServiceCXF {
    String hello(String content);
}
