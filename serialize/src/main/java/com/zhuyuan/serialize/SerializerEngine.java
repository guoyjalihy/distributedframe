package com.zhuyuan.serialize;

import com.zhuyuan.serialize.enumtype.SerializerType;
import com.zhuyuan.serialize.impl.hessian.HessianSerializer;
import com.zhuyuan.serialize.impl.java.DefaultJavaSerializer;
import com.zhuyuan.serialize.impl.json.JsonSerializer;
import com.zhuyuan.serialize.impl.protostuff.ProtostuffSerializer;
import com.zhuyuan.serialize.impl.thrift.ThriftSerializer;
import com.zhuyuan.serialize.impl.xml.XStreamSerializer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SerializerEngine {
    private static Map<SerializerType,ISerializer> serializers = new ConcurrentHashMap<>();
    static {
        serializers.put(SerializerType.JAVA,new DefaultJavaSerializer());
        serializers.put(SerializerType.XML,new XStreamSerializer());
        serializers.put(SerializerType.JSON,new JsonSerializer());
        serializers.put(SerializerType.HESSIAN,new HessianSerializer());
        serializers.put(SerializerType.THRIFT,new ThriftSerializer());
        serializers.put(SerializerType.PROTOSTUFF,new ProtostuffSerializer());
    }

    public static byte[] serialize(Object obj , SerializerType serializerType){
        System.out.println("begin serialize,type:" + serializerType.getType());
        Long begin_time = System.currentTimeMillis();
        byte[] serialize = serializers.get(serializerType).serialize(obj);
        Long finish_time = System.currentTimeMillis();
        System.out.println("end serialize.time:" + (finish_time - begin_time) + "ms.object size:" + serialize.length);
        return serialize;
    }

    public static <T> T deserialize(byte[] data , Class<T> clazz , SerializerType serializerType){
        System.out.println("begin deserialize,type:" + serializerType.getType());
        Long begin_time = System.currentTimeMillis();
        T deserialize = serializers.get(serializerType).deserialize(data, clazz);
        Long finish_time = System.currentTimeMillis();
        System.out.println("end deserialize.time:" + (finish_time - begin_time) + "ms.object:" + deserialize.toString());
        return deserialize;
    }
}
