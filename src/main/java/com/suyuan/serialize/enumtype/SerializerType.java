package com.suyuan.serialize.enumtype;

public enum SerializerType {

    JAVA("DefaultJavaSerializer"),
    XML("XStreamSerializer"),
    JSON("DefaultJavaSerializer"),
    HESSIAN("DefaultJavaSerializer"),
    THRIFT("DefaultJavaSerializer"),
    PROTOSTUFF("DefaultJavaSerializer"),
    AVRO("DefaultJavaSerializer");

    private SerializerType(String type){
        this.type = type;
    }
    private String type;
    public String getType() {
        return type;
    }
}

