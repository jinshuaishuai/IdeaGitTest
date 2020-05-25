package com.jin;

import com.google.gson.Gson;
import com.jin.entity.AO.UserAO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void testJson() {
        UserAO user = new UserAO();
        user.setAge(23);
        user.setName("张三");

        UserAO user2 = new UserAO();
        user2.setName("李四");
        user2.setAge(24);

        List<UserAO> list = new ArrayList<>();
        list.add(user);
        list.add(user2);

        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
