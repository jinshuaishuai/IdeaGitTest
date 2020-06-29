package com.jin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/4/20 17:27
 */
public class OrderNumberGeneratorUtil {
    private static int count = 0;

    private OrderNumberGeneratorUtil() {

    }

    public static String getOrderNumber() {
        count ++;
       return String.valueOf(count);
    }
}
