package com.suyuan.serialize.impl.java;

import com.suyuan.serialize.ISerializer;
import com.suyuan.serialize.domain.User;
import org.junit.jupiter.api.BeforeEach;

class DefaultJavaSerializerTest{
    public ISerializer iSerializer;
    public User user;
    @BeforeEach
    void setUp() {
        user = new User();
        user.setAge(18);
        user.setName("suyuan");
        iSerializer = new DefaultJavaSerializer();
    }

    @org.junit.jupiter.api.Test
    void serialize() {
        byte[] serialize = iSerializer.serialize(user);
        System.out.println(serialize.length);
    }

    @org.junit.jupiter.api.Test
    void deserialize() {
        User user = iSerializer.deserialize(iSerializer.serialize(this.user), User.class);
        System.out.println(user.toString());
    }

}