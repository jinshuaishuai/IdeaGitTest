package com.jin.quartz.controller;

import com.jin.quartz.schedule.ScheduleOneTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuai.jin
 * @date 2020/7/27 19:11
 */
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    /*@Autowired
    private ScheduleOneTask scheduleOneTask;

    @GetMapping(value = "/setSchedule")
    public String addScheduleTask(@RequestParam String cron) {
        scheduleOneTask.setCron(cron);
        return "Success";
    }*/
}
