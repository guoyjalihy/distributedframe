package com.zhuyuan.serialize.impl.hessian;

import com.zhuyuan.serialize.ISerializer;
import com.zhuyuan.serialize.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HessianSerializerTest{
    private ISerializer iSerializer;
    private User user;
    @BeforeEach
    void setUp() {
        user = new User();
        user.setAge(18);
        user.setName("suyuan");

        iSerializer = new HessianSerializer();
    }

    @Test
    void serialize() {
        byte[] serialize = iSerializer.serialize(user);
        System.out.println(serialize.length);
    }

    @Test
    void deserialize() {
        User deserialize = iSerializer.deserialize(iSerializer.serialize(user), User.class);
        System.out.println(deserialize.toString());
    }

}