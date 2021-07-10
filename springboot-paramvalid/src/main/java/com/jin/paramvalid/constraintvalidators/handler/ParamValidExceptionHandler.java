package com.jin.paramvalid.constraintvalidators.handler;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * 全局的异常参数校验处理类
 * @author shuai.jin
 * @date 2020/7/1 15:20
 */

@ControllerAdvice
@Slf4j
public class ParamValidExceptionHandler {

    /**
        处理javax.validation.constraints包下的例如@NotNull，@NotBlank等注解。
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity paramsValid(MethodArgumentNotValidException e) {
        String errorMessages = getErrorMessages(e.getBindingResult());
        return ResponseEntity.ok(errorMessages);
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseEntity bindException(BindException e) {
        String errorMessages = getErrorMessages(e.getBindingResult());
        return ResponseEntity.ok(errorMessages);
    }

    /**
     * 可以处理自定义的参数校验注解不通过的情况
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity ConstraintViolationExceptionHandler(ConstraintViolationException e) {

        Set<ConstraintViolation<?>> errorSet = e.getConstraintViolations();
        StringBuilder message = new StringBuilder();
        for (ConstraintViolation constraintViolation: errorSet) {
            ConstraintViolationImpl error = (ConstraintViolationImpl)constraintViolation;
            message.append(error.getMessage());
        }

        return  ResponseEntity.ok(message);
    }

    private String getErrorMessages(BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            allErrors.forEach(error -> {
                errorMessages.append(error.getDefaultMessage());
            });
            return errorMessages.toString();
        }

        return null;
    }
}
