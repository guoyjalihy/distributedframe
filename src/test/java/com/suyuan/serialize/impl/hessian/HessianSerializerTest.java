package com.suyuan.serialize.impl.hessian;

import com.suyuan.serialize.ISerializer;
import com.suyuan.serialize.domain.User;
import com.suyuan.serialize.domain.UserNotSerialize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HessianSerializerTest{
    private ISerializer iSerializer;
    public User user;
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