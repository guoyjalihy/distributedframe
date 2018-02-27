package com.suyuan.serialize;

import com.suyuan.serialize.domain.User;
import com.suyuan.serialize.domain.UserNotSerialize;
import com.suyuan.serialize.enumtype.SerializerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializerEngineTest {
    private UserNotSerialize userNotSerialize;
    private User user;
    @BeforeEach
    void setUp() {
        userNotSerialize = new UserNotSerialize();
        userNotSerialize.setAge(18);
        userNotSerialize.setName("userNotSerialize");

        user = new User();
        user.setAge(18);
        user.setName("suyuan");
    }

    @Test
    void serialize() {
        byte[] java = SerializerEngine.serialize(user, SerializerType.JAVA);
        byte[] xml = SerializerEngine.serialize(userNotSerialize, SerializerType.XML);
        byte[] json = SerializerEngine.serialize(userNotSerialize, SerializerType.JSON);
        byte[] hessian = SerializerEngine.serialize(user, SerializerType.HESSIAN);
        byte[] protostuff = SerializerEngine.serialize(userNotSerialize, SerializerType.PROTOSTUFF);
//        byte[] thrift = SerializerEngine.serialize(userNotSerialize, SerializerType.THRIFT);
    }

    @Test
    void deserialize() {
        User java = SerializerEngine.deserialize(SerializerEngine.serialize(user, SerializerType.JAVA), User.class, SerializerType.JAVA);
        UserNotSerialize xml = SerializerEngine.deserialize(SerializerEngine.serialize(userNotSerialize, SerializerType.XML), UserNotSerialize.class, SerializerType.XML);
        UserNotSerialize json = SerializerEngine.deserialize(SerializerEngine.serialize(userNotSerialize, SerializerType.JSON), UserNotSerialize.class, SerializerType.JSON);
        User hessian = SerializerEngine.deserialize(SerializerEngine.serialize(user, SerializerType.HESSIAN), User.class, SerializerType.HESSIAN);
        UserNotSerialize protostuff = SerializerEngine.deserialize(SerializerEngine.serialize(userNotSerialize, SerializerType.PROTOSTUFF), UserNotSerialize.class, SerializerType.PROTOSTUFF);
    }

}