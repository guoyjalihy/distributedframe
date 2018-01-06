package com.suyuan.serialize.impl.json;

import com.suyuan.serialize.ISerializer;
import com.suyuan.serialize.domain.User;
import com.suyuan.serialize.domain.UserNotSerialize;
import com.suyuan.serialize.impl.hessian.HessianSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JsonSerializerTest{
    private ISerializer iSerializer;
    public UserNotSerialize userNotSerialize;
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