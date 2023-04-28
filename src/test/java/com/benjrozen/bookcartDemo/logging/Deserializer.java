package com.benjrozen.bookcartDemo.logging;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class Deserializer extends StdDeserializer<String> {
    private static final long serialVersionUID = 1L;

    public Deserializer() {
        super(String.class);
    }

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // un-masking logic here. in our example we are removing "MASK"
        // string
        String s = p.getValueAsString();
        return s.substring(4);
    }
}
