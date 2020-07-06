package com.jin.controller;

import com.jin.common.config.RestResponse;
import com.jin.config.annotation.AvoidRepeatableCommit;
import com.jin.config.annotation.LogRecord;
import com.jin.entity.ao.UserAO;
import com.jin.entity.domain.EventDO;
import com.jin.entity.domain.PointDO;
import com.jin.entity.domain.UserDO;
import com.jin.entity.dto.UserPointDTO;
import com.jin.entity.query.EventQuery;
import com.jin.service.UserPointService;
import com.jin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/20 17:08
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPointService userPointService;

    @LogRecord(operatorModule = "用户管理模块", operatorType = "新增用户")
    //防止表单在规定时间内重复提交
    @AvoidRepeatableCommit
    @PostMapping(value = "/addUser")
    public RestResponse<String> addUser(@RequestBody @Validated UserAO userAo) throws NoSuchAlgorithmException {
        userService.addUser(userAo);
        return RestResponse.success();
    }

    @GetMapping(value = "/getUserPoint")
    public RestResponse<UserPointDTO> getUserPoint(@RequestParam int userId) {
        log.info("请求入参为：------>{}", userId);
        List<PointDO> userPointList = userPointService.getUserPoint(userId);
        UserDO userDo = userService.getUserById(userId);
        UserPointDTO userPointDto = new UserPointDTO();
        userPointDto.setUserDo(userDo);
        userPointDto.setPointDoList(userPointList);
        return RestResponse.success(userPointDto);
    }

    @PostMapping(value = "/getPointEventList")
    public RestResponse<List<EventDO>> getPointEventList(@RequestBody EventQuery eventQuery) {
        log.info("请求入参为：------>{}", eventQuery);
        List<EventDO> pointEventList = userPointService.getPointEventList(eventQuery);
        return RestResponse.success(pointEventList);
    }
}
