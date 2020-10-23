package com.example.demo.RAMJob;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class RAMQuartz {

    private static Logger _log = LoggerFactory.getLogger(RAMQuartz.class);

    public static void main(String[] args) throws SchedulerException {
        //1.创建scheduler工厂
        SchedulerFactory sf =new StdSchedulerFactory();
        //2.从工厂中获取调度器的实例
        Scheduler scheduler = sf.getScheduler();
        //创建jobDetail
        JobDetail jb= JobBuilder.newJob(RAMJob.class).withDescription("这是一个任务")//对任务的描述
                .withIdentity("ramJob","ramGroup")//job的name和组
                .build();
        //任务执行的时间，simpleSchedle类型的触发器的有效
        long time=System.currentTimeMillis()+5*1000L;//5秒后启动该线程
        Date starTime=new Date(time);
        //创建Trigger
           //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger t= (Trigger) TriggerBuilder.newTrigger().withDescription("")
                .withIdentity("ramTrigger","ramTriggerGroup")
                .startAt(starTime) //默认当前时间启动
                 .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")) //5秒查询一次
                  .build();
        //注册任务和定时器
        scheduler.scheduleJob(jb,t);
        //启动任务
        scheduler.start();
        _log.info("启动时间"+new Date());
        System.out.println("启动时间"+new Date());
    }

}
