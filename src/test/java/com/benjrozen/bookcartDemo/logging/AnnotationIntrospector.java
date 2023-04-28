package com.benjrozen.bookcartDemo.logging;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;

public class AnnotationIntrospector extends NopAnnotationIntrospector {

    private static final long serialVersionUID = 1L;

    @Override
    public Object findSerializer(Annotated am) {
        MaskSensitiveData annotation = am.getAnnotation(MaskSensitiveData.class);
        if (annotation != null) {
            return Serializer.class;
        }
        return null;
    }

    @Override
    public Object findDeserializer(Annotated am) {
        MaskSensitiveData annotation = am.getAnnotation(MaskSensitiveData.class);
        if (annotation != null) {
            return Deserializer.class;
        }
        return null;
    }
}
