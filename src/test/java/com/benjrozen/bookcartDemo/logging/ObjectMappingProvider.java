package com.benjrozen.bookcartDemo.logging;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.google.inject.Provider;
import io.restassured.config.Config;
import io.restassured.config.ObjectMapperConfig;


public class ObjectMappingProvider implements Provider<ObjectMapper> {


    public ObjectMapper get() {
        ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

        AnnotationIntrospector sis = mapper.getSerializationConfig().getAnnotationIntrospector();
        AnnotationIntrospector dis = mapper.getDeserializationConfig().getAnnotationIntrospector();

        AnnotationIntrospector is1 = AnnotationIntrospectorPair.pair(sis, new com.benjrozen.bookcartDemo.logging.AnnotationIntrospector());
        AnnotationIntrospector is2 = AnnotationIntrospectorPair.pair(dis, new com.benjrozen.bookcartDemo.logging.AnnotationIntrospector());

        mapper.setAnnotationIntrospectors(is1, is2);
        return mapper;
    }

}
