package com.jin.test;

import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/21 9:57
 */
public class Md5YTest {

    @Test
    public void md5Test() throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");

        byte[] digest = md5.digest("518629cp3".getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        String s = encoder.encodeToString(digest);
        System.out.println(s.length());
        System.out.println(s);

    }
}
