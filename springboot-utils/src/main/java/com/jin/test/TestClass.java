package com.jin.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author shuai.jin
 * @date 2020/7/29 15:08
 */
public class TestClass {

    public static void main(String[] args) throws ClassNotFoundException, UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress.getHostAddress());
    }
}
