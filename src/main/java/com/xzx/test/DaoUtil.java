package com.xzx.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DaoUtil {

    public static String datetoString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    public static  String TransTimestampToSqlDate(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        String dateStr = datetoString(date);
        return dateStr;
    }
}
