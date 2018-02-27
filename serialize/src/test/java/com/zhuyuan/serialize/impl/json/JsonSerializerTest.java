package com.zhuyuan.serialize.impl.json;

import com.zhuyuan.serialize.ISerializer;
import com.zhuyuan.serialize.domain.UserNotSerialize;
import com.zhuyuan.serialize.impl.hessian.HessianSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JsonSerializerTest{
    private ISerializer iSerializer;
    private UserNotSerialize userNotSerialize;
    @BeforeEach
    void setUp() {
        userNotSerialize = new UserNotSerialize();
        userNotSerialize.setAge(18);
        userNotSerialize.setName("userNotSerialize");

        iSerializer = new HessianSerializer();
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