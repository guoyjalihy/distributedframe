package com.suyuan.serialize.enumtype;

public enum SerializerType {

    JAVA("DefaultJavaSerializer"),
    XML("XStreamSerializer"),
    JSON("JsonSerializer"),
    HESSIAN("HessianSerializer"),
    THRIFT("ThriftSerializer"),
    PROTOSTUFF("ProtostuffSerializer");

    SerializerType(String type){
        this.type = type;
    }
    private String type;
    public String getType() {
        return type;
    }
}

