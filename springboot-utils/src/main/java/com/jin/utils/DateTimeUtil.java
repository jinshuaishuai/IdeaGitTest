package com.jin.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author shuai.jin
 * @date 2020/8/6 10:53
 */
public class DateTimeUtil {
    public static void main(String[] args) {
        DateTime parse = DateTime.parse("2020-8-6 11:06", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm"));
        System.out.println(parse.getMillis());
        System.out.println(System.currentTimeMillis());
    }
}
