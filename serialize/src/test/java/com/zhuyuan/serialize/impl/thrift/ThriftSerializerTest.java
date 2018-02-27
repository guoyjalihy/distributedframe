package com.zhuyuan.serialize.impl.thrift;

import com.zhuyuan.serialize.ISerializer;
import com.zhuyuan.serialize.domain.UserNotSerialize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThriftSerializerTest {
    private ISerializer iSerializer;
    private UserNotSerialize userNotSerialize;
    @BeforeEach
    void setUp() {
        userNotSerialize = new UserNotSerialize();
        userNotSerialize.setAge(18);
        userNotSerialize.setName("userNotSerialize");

        iSerializer = new ThriftSerializer();
    }
    @Test
    void serialize() {
        byte[] serialize = iSerializer.serialize(userNotSerialize);
        System.out.println(serialize.length);
    }

    @Test
    void deserialize() {
        UserNotSerialize deserialize = iSerializer.deserialize(iSerializer.serialize(userNotSerialize), UserNotSerialize.class);
        System.out.println(deserialize.toString());
    }

}