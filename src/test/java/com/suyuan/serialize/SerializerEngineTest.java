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
        System.out.println("java:"+java.length);
        byte[] xml = SerializerEngine.serialize(userNotSerialize, SerializerType.XML);
        System.out.println("xml:"+xml.length);
        byte[] json = SerializerEngine.serialize(userNotSerialize, SerializerType.JSON);
        System.out.println("json:"+json.length);
        byte[] hessian = SerializerEngine.serialize(user, SerializerType.HESSIAN);
        System.out.println("hessian:"+hessian.length);
        byte[] protostuff = SerializerEngine.serialize(userNotSerialize, SerializerType.PROTOSTUFF);
        System.out.println("protostuff:"+protostuff.length);
//        byte[] thrift = SerializerEngine.serialize(userNotSerialize, SerializerType.THRIFT);
//        System.out.println("thrift:"+thrift.length);
    }

    @Test
    void deserialize() {
        User java = SerializerEngine.deserialize(SerializerEngine.serialize(user, SerializerType.JAVA), User.class, SerializerType.JAVA);
        System.out.println(java.toString());
        UserNotSerialize xml = SerializerEngine.deserialize(SerializerEngine.serialize(userNotSerialize, SerializerType.XML), UserNotSerialize.class, SerializerType.XML);
        System.out.println(xml.toString());
        UserNotSerialize json = SerializerEngine.deserialize(SerializerEngine.serialize(userNotSerialize, SerializerType.JSON), UserNotSerialize.class, SerializerType.JSON);
        System.out.println(json.toString());
        User hessian = SerializerEngine.deserialize(SerializerEngine.serialize(user, SerializerType.HESSIAN), User.class, SerializerType.HESSIAN);
        System.out.println(hessian.toString());
        UserNotSerialize protostuff = SerializerEngine.deserialize(SerializerEngine.serialize(userNotSerialize, SerializerType.PROTOSTUFF), UserNotSerialize.class, SerializerType.PROTOSTUFF);
        System.out.println(protostuff.toString());
    }

}