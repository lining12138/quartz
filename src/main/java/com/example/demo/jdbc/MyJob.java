package com.example.demo.jdbc;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.dnd.DropTarget;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyJob implements Job {

    private static final Logger log=LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("任务的开始");
        log.info("你好。。"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        log.info("工作结束");
        System.out.println("任务的开始");
        System.out.println("你好。。"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("工作结束");
    }
}
