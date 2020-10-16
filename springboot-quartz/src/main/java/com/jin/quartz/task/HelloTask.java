package com.jin.quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author shuai.jin
 * @date 2020/8/18 18:29
 */
@Slf4j
public class HelloTask implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("业务处理类进行中");
    }
}
