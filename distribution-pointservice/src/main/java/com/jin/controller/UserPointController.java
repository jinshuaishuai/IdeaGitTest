package com.jin.controller;

import com.jin.entity.domain.EventDO;
import com.jin.entity.domain.PointDO;
import com.jin.entity.query.EventQuery;
import com.jin.mapper.EventMapper;
import com.jin.service.EventService;
import com.jin.service.UserPointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/getUserPointList")
    public List<PointDO> getUserPointList(@RequestParam(value = "userId") int userId) {
        log.info("请求入参为：------>{}", userId);
        List<PointDO> list = userPointService.getUserPointList(userId);
        return list;
    }

    @PostMapping(value = "/getPointEventList")
    public List<EventDO> getPointEventList(@RequestBody EventQuery eventQuery) {
        log.info("接口入参为：------>{}", eventQuery);
        return eventService.getEventListByParams(eventQuery);
    }
}
