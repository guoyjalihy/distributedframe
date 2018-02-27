package com.zhuyuan.serialize;

import com.zhuyuan.serialize.domain.User;
import com.zhuyuan.serialize.domain.UserNotSerialize;
import com.zhuyuan.serialize.enumtype.SerializerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        SerializerEngine.serialize(user, SerializerType.JAVA);
        SerializerEngine.serialize(userNotSerialize, SerializerType.XML);
        SerializerEngine.serialize(userNotSerialize, SerializerType.JSON);
        SerializerEngine.serialize(user, SerializerType.HESSIAN);
        SerializerEngine.serialize(userNotSerialize, SerializerType.PROTOSTUFF);
//        byte[] thrift = SerializerEngine.serialize(userNotSerialize, SerializerType.THRIFT);
    }

    @Test
    void deserialize() {
        SerializerEngine.deserialize(SerializerEngine.serialize(user, SerializerType.JAVA), User.class, SerializerType.JAVA);
        SerializerEngine.deserialize(SerializerEngine.serialize(userNotSerialize, SerializerType.XML), UserNotSerialize.class, SerializerType.XML);
        SerializerEngine.deserialize(SerializerEngine.serialize(userNotSerialize, SerializerType.JSON), UserNotSerialize.class, SerializerType.JSON);
        SerializerEngine.deserialize(SerializerEngine.serialize(user, SerializerType.HESSIAN), User.class, SerializerType.HESSIAN);
        SerializerEngine.deserialize(SerializerEngine.serialize(userNotSerialize, SerializerType.PROTOSTUFF), UserNotSerialize.class, SerializerType.PROTOSTUFF);
    }

}