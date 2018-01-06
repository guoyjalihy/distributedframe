package com.suyuan.serialize.impl.java;

import com.suyuan.serialize.ISerializer;

import java.io.*;

public class DefaultJavaSerializer implements ISerializer {
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream ;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayInputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return byteArrayInputStream.toByteArray();
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T)objectInputStream.readObject();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
