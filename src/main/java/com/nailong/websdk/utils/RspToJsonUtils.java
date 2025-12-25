package com.nailong.websdk.utils;

import com.nailong.websdk.pojo.HttpRsp;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RspToJsonUtils {
    public static HttpRsp success(Object data) {
        if (data == null || data.toString().isEmpty()) {
            data = "{}";
        }

        return new HttpRsp(200, data, "OK");
    }

    public static HttpRsp error(Object data) {
        if (data == null || data.toString().isEmpty()) {
            data = "{}";
        }

        return new HttpRsp(404, data, "Error");
    }

    public static HttpRsp error(Object data, Exception exception) {
        if (data == null || data.toString().isEmpty()) {
            data = "{}";
        }

        log.error(exception);
        return new HttpRsp(404, data, "Error");
    }

    public static HttpRsp error(String message) {
        if (message == null || message.isEmpty()) {
            message = "Error";
        }

        return new HttpRsp(404, "{}", message);
    }

    public static HttpRsp error(String message, Exception exception) {
        if (message == null || message.isEmpty()) {
            message = "Error";
        }

        return new HttpRsp(404, "{}", message);
    }

    public static HttpRsp error(int code, Object data) {
        if (data == null || data.toString().isEmpty()) {
            data = "{}";
        }

        return new HttpRsp(code, data, "Error");
    }

    public static HttpRsp error(int code, Object data, String msg) {
        if (data == null || data.toString().isEmpty()) {
            data = "{}";
        }

        return new HttpRsp(code, data, msg);
    }
}
