package com.imooc.quartz;

import org.quartz.*;
import org.quartz.core.jmx.JobDetailSupport;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/20 0020.
 */
public class MySchedulerWithCron {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();

        Trigger cronTrigger = (CronTrigger)TriggerBuilder
                .newTrigger()
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("5/10 45/5 17 ? * 7 *"))
                .build();

        Scheduler cronScheduler = StdSchedulerFactory.getDefaultScheduler();
        Date execDate = cronScheduler.scheduleJob(jobDetail, cronTrigger);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(execDate));

        cronScheduler.start();
    }
}
