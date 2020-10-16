package com.effective;

import org.apache.commons.codec.digest.Md5Crypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/10/13 10:38
 */
public class Goods {

    public static void main(String[] args) {
        String str = "abc.0";
        str.replace(".0", "");
        System.out.println(str);

        System.out.println(str.endsWith(".0"));

        System.out.println(str.substring(0, str.length() - 2));
    }
}
