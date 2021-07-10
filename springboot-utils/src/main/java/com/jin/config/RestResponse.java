package com.jin.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname RestResponse
 * @Description TODO
 * @Date 2021/7/10 11:05
 * @Created by jinshuai
 */
@Data
public class RestResponse<T> implements Serializable {


    private  String code = "SUCCESS";

    private  String message = "操作成功";

    private  T data;

    public static<T> RestResponse<T> success(T data) {
        RestResponse<T> response = new RestResponse<>();
        response.data = data;
        return response;
    }

    public static<T> RestResponse<T> success() {
        RestResponse<T> response = new RestResponse<>();
        return response;
    }

    public static RestResponse error(String code, String message) {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(code);
        restResponse.setMessage(message);
        return restResponse;
    }

}
