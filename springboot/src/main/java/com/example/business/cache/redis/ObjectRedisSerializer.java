package com.example.business.cache.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * 自定义的序列化和反序列化方法
 *
 * @author yuanweipeng
 * @date 2018-01-19
 **/
public class ObjectRedisSerializer implements RedisSerializer<Object> {

    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    private Converter<Object, byte[]> serializer = new SerializingConverter();

    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null) {
            return EMPTY_BYTE_ARRAY;
        }

        try {
            return serializer.convert(o);
        } catch (Exception e) {
            throw new SerializationException("Redis serialization error. Message:" + e.getMessage());
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        try {
            return deserializer.convert(bytes);
        } catch (Exception e) {
            throw new SerializationException("Redis deserialization error. Message:" + e.getMessage());
        }
    }
}
