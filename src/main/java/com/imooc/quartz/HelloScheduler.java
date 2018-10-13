package com.imooc.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder
                .newJob(MyJob.class)
                .withIdentity("MyJobDetail", "Group1")
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("MyJobTrigger", "Triggers")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .repeatForever()
                                .withIntervalInSeconds(10))
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
    }
}
