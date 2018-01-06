package com.suyuan.serialize.impl.xml;

import com.suyuan.serialize.ISerializer;
import com.suyuan.serialize.domain.UserNotSerialize;
import com.suyuan.serialize.impl.hessian.HessianSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XStreamSerializerTest{
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
        UserNotSerialize deserialize = iSerializer.deserialize(iSerializer.serialize(this.userNotSerialize), UserNotSerialize.class);
        System.out.println(deserialize.toString());
    }

}