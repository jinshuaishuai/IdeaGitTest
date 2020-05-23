package com.jin.controller;

import com.jin.entity.domain.UserInfoDO;
import com.jin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:15
 */
@RestController
@RequestMapping(value = "/test")

public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "getUserInfoById")
    public UserInfoDO getUserInfoById(@RequestParam int id) {
        UserInfoDO value = userInfoService.getUserInfoById(id);
        return value;
    }
}
