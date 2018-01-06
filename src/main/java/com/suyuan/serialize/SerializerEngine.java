package com.suyuan.serialize;

import com.suyuan.serialize.enumtype.SerializerType;
import com.suyuan.serialize.impl.hessian.HessianSerializer;
import com.suyuan.serialize.impl.java.DefaultJavaSerializer;
import com.suyuan.serialize.impl.json.JsonSerializer;
import com.suyuan.serialize.impl.protostuff.ProtostuffSerializer;
import com.suyuan.serialize.impl.thrift.ThriftSerializer;
import com.suyuan.serialize.impl.xml.XStreamSerializer;

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
        return serializers.get(serializerType).serialize(obj);
    }

    public static <T> T deserialize(byte[] data , Class<T> clazz , SerializerType serializerType){
        return serializers.get(serializerType).deserialize(data, clazz);
    }
}
