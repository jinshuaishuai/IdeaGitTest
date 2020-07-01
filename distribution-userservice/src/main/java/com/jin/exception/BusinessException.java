package com.jin.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shuai.jin
 * @date 2020/7/1 16:05
 */
@Setter
@Getter
public abstract class BusinessException extends RuntimeException {

    protected String code;

    protected String message;

    public BusinessException() {
        super();
    }

}
