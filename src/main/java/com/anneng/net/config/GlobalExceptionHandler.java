package com.anneng.net.config;


import com.anneng.net.Excepation.MyRuntimeException;
import com.anneng.net.util.ApiResponse;
import com.anneng.net.util.ResponseUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

/*
 * 全局异常捕获
 * */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyRuntimeException.class)
    @ResponseBody
    public ApiResponse handle(Exception e) {
        return ResponseUtil.error(-1,   e.getMessage());
    }

}
