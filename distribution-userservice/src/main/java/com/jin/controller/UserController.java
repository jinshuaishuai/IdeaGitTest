package com.jin.controller;

import com.jin.common.config.RestResponse;
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

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody @Validated UserAO userAo) {
        userService.addUser(userAo);
        return "Success";
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
