package com.zhuyuan.serialize;
public interface ISerializer {
    /**
     * 序列化
     * @param obj 待序列化对象
     * @param <T> 泛型
     * @return 字节数组
     */
    <T> byte[] serialize(T obj);

    /**
     * 反序列化
     * @param data 字节数组
     * @param clazz 类型
     * @param <T> 泛型
     * @return 类型
     */
    <T> T deserialize(byte[] data , Class<T> clazz);
}
