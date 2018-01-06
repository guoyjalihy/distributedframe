package com.suyuan.serialize.impl.protostuff;

import com.dyuproject.protostuff.*;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.suyuan.serialize.ISerializer;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProtostuffSerializer implements ISerializer {
    private static Map<Class<?>,Schema<?>> cachedSchema = new ConcurrentHashMap<>();
    private static Objenesis objenesis = new ObjenesisStd(true);
    private static <T> Schema<T> getSchema(Class<T> clazz){
        Schema<T> schema = (Schema<T>) cachedSchema.get(clazz);
        if (schema == null){
            schema = RuntimeSchema.createFrom(clazz);
            cachedSchema.put(clazz,schema);
        }
        return schema;
    }
    @Override
    public <T> byte[] serialize(T obj) {
        LinkedBuffer linkedBuffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        Schema<T> schema = (Schema<T>) getSchema(obj.getClass());
        try {
            return ProtostuffIOUtil.toByteArray(obj,schema,linkedBuffer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            linkedBuffer.clear();
        }
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        T obj = objenesis.newInstance(clazz);
        Schema<T> schema = getSchema(clazz);
        ProtostuffIOUtil.mergeFrom(data,obj,schema);
        return obj;
    }
}
