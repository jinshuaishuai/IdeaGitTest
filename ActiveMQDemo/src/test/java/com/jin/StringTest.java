package com.jin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    Pattern pattern = Pattern.compile("^([0-9\\.]*):(.*)");
    public static void main(String[] args) {
        StringTest str = new StringTest();
//        str.test();
        str.print();
    }



    public static String getSubAddress(String remoteAddress) {
        String subAddress = null;
        for (int i = 0; i < remoteAddress.length(); i++) {
            char ch = remoteAddress.charAt(i);
            if (ch >= '0' && ch <= '9') {
                subAddress = remoteAddress.substring(i);
                break;
            }
        }
        return subAddress;
    }

    public void test() {
        String remoteAddress = "tcp://172.89.2.89:12345";
        //获取允许访问的IP列表
        String ips = "192.168.192.134,128.89.98.20,138.90.27.86";
        String str = getSubAddress(remoteAddress);
        Matcher matcher = pattern.matcher(str);
        Boolean findIP = false;
        if (matcher.matches()) {
            String ip = matcher.group(1);
            String[] ipList= ips.split(",");
            for(int i=0 ;i<ipList.length;i++){
                if(ipList[i].equals(ip)){
                    findIP = true;
                    break;
                }
            }

            if(!findIP){
                throw new SecurityException("Connecting from IP address " + ip + " is not allowed" );
            }

        } else {
            throw new SecurityException("Invalid remote address " + remoteAddress + "subAddress " + getSubAddress(remoteAddress));
        }
        System.out.println("通过IP拦截");
    }

    public void print() {
        String phone = "tcp://127.0.0.1:6572";
        Pattern pattern = Pattern.compile("([0,1]?\\d{1,2}|2([0-4][0-9]|5[0-5]))(\\.([0,1]?\\d{1,2}|2([0-4][0-9]|5[0-5]))){3}");
        Matcher matcher = pattern.matcher(phone);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
       /* if(matcher.matches()) {
            String group = matcher.group(0);

            System.out.println(group);
        }*/
    }
}
