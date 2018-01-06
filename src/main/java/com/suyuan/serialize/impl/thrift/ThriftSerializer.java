package com.suyuan.serialize.impl.thrift;

import com.suyuan.serialize.ISerializer;
import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.*;

public class ThriftSerializer implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        TSerializer tBinaryProtocol = new TSerializer(new TBinaryProtocol.Factory());
        TSerializer tCompactProtocol = new TSerializer(new TCompactProtocol.Factory());
        TSerializer tJSONProtocol = new TSerializer(new TJSONProtocol.Factory());
        TSerializer tTupleProtocol = new TSerializer(new TTupleProtocol.Factory());
        try {
            return tBinaryProtocol.serialize((TBase) obj);
//            return tCompactProtocol.serialize((TBase) obj);
//            return tJSONProtocol.serialize((TBase) obj);
//            return tTupleProtocol.serialize((TBase) obj);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        TDeserializer tDeserializer = new TDeserializer();
        try {
            TBase tBase = (TBase) clazz.newInstance();
            tDeserializer.deserialize(tBase,data);
            return (T) tBase;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
