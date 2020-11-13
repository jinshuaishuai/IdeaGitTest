package com.sepa;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 * @author shuai.jin
 * @date 2020/11/13 10:12
 */
public class ThousandSeparator {

    public static void main(String[] args) {

        BigDecimal bd = new BigDecimal(25);
        BigDecimal divide = bd.divide(new BigDecimal(10000));
        System.out.println(divide);

        DecimalFormat df = new DecimalFormat("");
        String format = df.format(divide);
        System.out.println(format);
    }

    private static void test1() {
        Object num = 123.00;
        if(num instanceof Number) {
            Number nu = (Number) num;
            BigDecimal bd = new BigDecimal(String.valueOf(nu));
        }

        BigDecimal bd = new BigDecimal("123.00");
        System.out.println(parseNumber(",###", bd));
        System.out.println(parseNumber(",###.00", bd));
        System.out.println(parseNumber(".00", bd));
    }

    public static String parseNumber(String pattern, BigDecimal bd) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(bd);
    }
}
