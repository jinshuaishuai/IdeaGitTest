package com.jin.exception.handler;

import com.jin.config.RestResponse;
import com.jin.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * @author shuai.jin
 * @date 2020/7/1 15:54
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = SQLException.class)
    public RestResponse<String> exceptionHandle(SQLException e) {
        log.error("sql错误：------>{}", e.toString());
        return RestResponse.error("500", e.toString());
    }

    //全局的业务异常处理类
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public RestResponse<String> businessExceptionHandle(BusinessException e) {
        log.error("业务异常：------>{}", e.getMessage());
        return RestResponse.error(e.getCode(), e.getMessage());
    }

    /*@ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RestResponse<String> exceptionHandle(Exception e) {
        log.error("业务异常：------>{}", e.getMessage());
        return RestResponse.error("500", e.getMessage());
    }*/
}
