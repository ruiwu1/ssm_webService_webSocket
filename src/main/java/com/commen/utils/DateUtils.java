package com.commen.utils;

import sun.applet.Main;

import java.text.SimpleDateFormat;
import java.util.Date;

//获取当前时间
public class DateUtils {

    public  static String getDateTime(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(day);
        System.out.println(date);
        return date;
    }

}
