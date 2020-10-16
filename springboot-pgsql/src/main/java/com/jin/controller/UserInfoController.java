package com.jin.controller;

import com.jin.entity.domain.UserInfoDO;
import com.jin.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:15
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "getUserInfoById")
    public UserInfoDO getUserInfoById(@RequestParam(value = "id") int id) {
        log.info("接口请求入参为：------>{}", id);
        UserInfoDO value = userInfoService.getUserInfoById(id);
        return value;
    }

    @GetMapping(value = "getDynamicQueryResult")
    public List<Map<String, Object>> getDynamicQueryResult() {

        List<Map<String, Object>> result = userInfoService.getDynamicQueryResult();
        return result;
    }
}
