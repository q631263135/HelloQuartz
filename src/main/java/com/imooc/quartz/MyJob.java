package com.imooc.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date currentDate = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(currentDate));
        System.out.println("Hello Quartz");

        JobDetail jobDetail = jobExecutionContext.getJobDetail();

        System.out.println("jobDetail key name: "
                + jobDetail.getKey().getName()
                + ", jobDetail key group: "
                + jobDetail.getKey().getGroup());

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        System.out.println(jobDataMap.getString("name"));
        System.out.println(jobDataMap.getInt("age"));
    }
}
