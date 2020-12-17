package com.jin.entity.query;

import com.google.gson.Gson;
import com.jin.entity.domain.UserInfoDo;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/9/15 16:23
 */
public class BaseUserInfoQuery {

    private List<String> dimensionFieldNames;

    private List<String> normFieldNames ;

    private Integer aggregationType;

    public static void main(String[] args) {
        List<UserInfoDo> items = new ArrayList<>();
        UserInfoDo nihao = UserInfoDo.builder()
                .name("nihao")
                .phone("123")
                .age(23)
                .build();
        items.add(nihao);
        Gson gson = new Gson();
        System.out.println(gson.toJson(items));
    }
}
