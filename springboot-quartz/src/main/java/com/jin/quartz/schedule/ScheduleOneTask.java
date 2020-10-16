package com.jin.quartz.schedule;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author shuai.jin
 * @date 2020/7/27 17:28
 */
//@Component
@EnableScheduling
public class ScheduleOneTask implements SchedulingConfigurer {

    private String cron = "*/2 * * * * *";

    public void setCron(String cron) {
        this.cron = cron;
    }

    public ScheduleOneTask() {

    }

    public ScheduleOneTask(String cron) {
        this.cron = cron;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {


        Trigger cronTrigger = new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                Date date = triggerContext.lastScheduledExecutionTime();

                CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        };
        TriggerTask triggerTask = new TriggerTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("I Love you! Wife!");
            }
        },cronTrigger);
        taskRegistrar.addTriggerTask(triggerTask);

        /*Runnable task = new Runnable() {
            @Override
            public void run() {
                //任务逻辑代码部分.
                System.out.println("I am going:" + LocalDateTime.now());
            }
        };
        Trigger trigger = new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        };*/

    }
}
