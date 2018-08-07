package com.airy.saltedfish.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Airy on 2017/11/15
 */

public class DateUtil {

    public static Date getDate(){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,0);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        return date;
    }

    public static String getDateString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static void main(String[] args) {
        System.out.println(getDate());
        System.out.println(getDateString(getDate()));
    }

}
