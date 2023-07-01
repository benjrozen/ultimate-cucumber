package com.benjrozen.bookcartDemo.logging;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class Serializer extends StdSerializer<String> {

    private static final long serialVersionUID = 1L;

    public Serializer() {
        super(String.class);
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString("******");
    }
}
