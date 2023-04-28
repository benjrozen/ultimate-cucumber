package com.benjrozen.bookcartDemo.restAssured;

import com.benjrozen.bookcartDemo.logging.Deserializer;
import com.benjrozen.bookcartDemo.logging.MaskSensitiveData;
import com.benjrozen.bookcartDemo.logging.Serializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

public class ObjectMappingZ implements ObjectMapper {


    @Override
    public Object deserialize(ObjectMapperDeserializationContext context) {
        MaskSensitiveData annotation = context.getClass().getAnnotation(MaskSensitiveData.class);
        if (annotation != null) {
            return Serializer.class;
        }
        return null;
    }

    @Override
    public Object serialize(ObjectMapperSerializationContext context) {
        MaskSensitiveData annotation = context.getClass().getAnnotation(MaskSensitiveData.class);
        if (annotation != null) {
            return Serializer.class;
        }
        return null;
    }
}
