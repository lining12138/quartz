package com.example.demo.RAMJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class RAMJob implements Job {

    private static Logger _log= LoggerFactory.getLogger(RAMJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        _log.info("现在执行一个任务"+new Date());
        System.out.println("执行一个任务"+new Date());
    }
}
