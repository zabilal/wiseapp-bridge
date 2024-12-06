package com.nova.ServerBridge.Protocol;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Zakariyya Raji on 2017-12-19-12-16.
 * <p>
 * Serializes objects to JSON and back.
 */
public abstract class Serializer {

    /**
     * Serializes an object as JSON.
     *
     * @param object containing simple types that allow JSON transform.
     * @return a JSON string representing the object.
     */
    public static String pack(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing POJO.");
        }
    }

    /**
     * Deserializes a JSON string into an object.
     *
     * @param json   String containing the object values.
     * @param format class to be populated with the key/value pair.
     * @return an unpacked object.
     */
    public static Object unpack(String json, Class format) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            return mapper.readValue(json, format);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage() + " for " + json);
        }
    }
}
