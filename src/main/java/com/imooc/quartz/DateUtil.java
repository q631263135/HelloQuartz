package com.imooc.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
public class DateUtil {
    public static void printCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date date = new Date();
        System.out.println(sdf.format(date));
    }
}
