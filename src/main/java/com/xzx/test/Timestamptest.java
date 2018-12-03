package com.xzx.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Timestamptest {

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


    public static void main(String[] args) {
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        System.out.println();
    }



}
