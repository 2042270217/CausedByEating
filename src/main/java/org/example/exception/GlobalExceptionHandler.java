package org.example.exception;

import ch.qos.logback.core.util.StringUtil;
import org.example.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.error(StringUtil.isNullOrEmpty(e.getMessage()) ? "操作失败" : e.getMessage());
    }
}
