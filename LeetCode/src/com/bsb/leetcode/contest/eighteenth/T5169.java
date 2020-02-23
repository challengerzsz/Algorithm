package com.bsb.leetcode.contest.eighteenth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-23 10:31
 */
public class T5169 {

    // 日期之间间隔几天
    public int daysBetweenDates(String date1, String date2) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1Date;
        Date date2Date;
        Long l = 0L;
        try {
            date1Date = formatter.parse(date1);
            long ts = date1Date.getTime();
            date2Date = formatter.parse(date2);
            long ts1 = date2Date.getTime();

            l = (ts - ts1) / (1000 * 60 * 60 * 24);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Math.abs(l.intValue());
    }
}
