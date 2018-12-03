package com.xzx.util;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class DateToTimestamp {

        /**
         * 将Date转换成String
         * @param date
         * @return
         */
        public static String date2String(Date date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdf.format(date);
            return dateStr;
        }

        /**
         * 将Timestamp转换成String
         * 用于数据库中字段类型为datetime
         * @param timestamp
         * @return
         *
         */
        public static String time2String(Timestamp timestamp) {
            Date date = new Date(timestamp.getTime());
            String dateStr = date2String(date);
            return dateStr;
        }



        public static Timestamp DateTransTimestamp(Date date){
            return new Timestamp(date.getTime());
        }


    public static void main(String[] args) {
        List<String> dateList =new ArrayList<String>();
        List<Integer> numList = new ArrayList<Integer>();
        Calendar c = Calendar.getInstance();
        Date d;
        String day;
        SimpleDateFormat format;
        for(int i=-7;i<0;i++){

            c = Calendar.getInstance();
            format = new SimpleDateFormat("yyyy-MM-dd");
            //过去七天
            c.setTime(new Date());
            c.add(Calendar.DATE, i);
            d = c.getTime();
            day = format.format(d);
            System.out.println(day);
            dateList.add(day);
            numList.add(i+20);
        }
        System.out.println(dateList.get(0));
        System.out.println(numList.get(0));

       // java.util.Date timeNow = df.parse(time);
    }



}
