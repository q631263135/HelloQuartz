package com.imooc.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder
                .newJob(MyJob.class)
                .withIdentity("MyJobDetail", "Group1")
                .usingJobData("name", "ycz")
                .usingJobData("age", 15)
                .build();

        DateUtil.printCurrentTime();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("MyJobTrigger", "Triggers")
//                .startNow()
                .startAt(new Date(new Date().getTime() + 5000))
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
//                                .repeatForever()
                                .withRepeatCount(5)
                                .withIntervalInSeconds(10))
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
    }
}
