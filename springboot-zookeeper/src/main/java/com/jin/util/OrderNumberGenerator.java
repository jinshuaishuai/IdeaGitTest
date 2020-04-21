package com.jin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/4/20 17:27
 */
public class OrderNumberGenerator {
    private int count = 0;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getOrderNumber() {
        count ++;
        if(count == 100) {
            count = 0;
        }
       return sdf.format(new Date()) + count;
    }
}
