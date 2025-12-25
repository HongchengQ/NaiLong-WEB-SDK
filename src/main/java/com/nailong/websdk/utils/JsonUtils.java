package com.nailong.websdk.utils;

import tools.jackson.databind.ObjectMapper;

import static com.nailong.websdk.common.Common.strIsEmpty;

public class JsonUtils {
    public static <T> T jsonToObject(String jsonStr, Class<T> clazz) {
        if (strIsEmpty(jsonStr)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonStr, clazz);
    }
}
