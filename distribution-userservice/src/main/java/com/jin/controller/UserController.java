package com.jin.controller;

import com.jin.entity.ao.UserAO;
import com.jin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuai.jin
 * @date 2020/6/20 17:08
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody @Validated UserAO userAo) {
        userService.addUser(userAo);
        return "Success";
    }
}
