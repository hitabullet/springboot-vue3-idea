package com.end.project.common.exception;

import com.end.project.entity.ResultSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalAccessException.class)
    public ResultSet handler(IllegalAccessException e) {
        log.error("Assert异常: ---------- {}",e.getMessage());
        return ResultSet.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ResultSet handler(RuntimeException e) {
        log.error("运行异常: ---------- {}",e.getMessage());
        return ResultSet.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = TokenException.class)
    public ResultSet arithmeticException(TokenException e) {
        log.error("除数不能为0：{} ", e.getMessage(), e);
        return ResultSet.fail("除数不能为0");
    }


}
