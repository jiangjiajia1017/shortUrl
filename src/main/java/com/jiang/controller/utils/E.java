package com.jiang.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理
@RestControllerAdvice
public class E {

    @ExceptionHandler
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error("服务器错误，请稍后重试！");
    }
}
