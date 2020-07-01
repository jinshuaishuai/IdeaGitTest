package com.jin.exception;

/**
 * @author shuai.jin
 * @date 2020/7/1 16:16
 */
public class UserAddException extends BusinessException {

    public UserAddException(String message) {
        this("500", message);
    }
    public UserAddException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
