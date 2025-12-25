package com.nailong.websdk.exception;

import com.nailong.websdk.pojo.HttpRsp;
import com.nailong.websdk.utils.RspToJsonUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpRsp handleValidationException(MethodArgumentNotValidException e) {
        // 统一处理参数校验异常
        return RspToJsonUtils.error("参数校验失败", e);
    }
}