package com.jin.controller;

import com.jin.entity.domain.PointDO;
import com.jin.service.UserPointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/21 19:24
 */
@RestController
@RequestMapping("/userpoint")
@Slf4j
public class UserPointController {

    @Autowired
    private UserPointService userPointService;

    @GetMapping(value = "/getUserPointList")
    public List<PointDO> getUserPointList(@RequestParam(value = "userId") int userId) {
        log.info("请求入参为：------>{}", userId);
        List<PointDO> list = userPointService.getUserPointList(userId);
        return list;
    }
}
