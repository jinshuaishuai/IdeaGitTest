package com.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/9/3 17:05
 */
public class SystemMillsecond {
    public static void main(String[] args) {
        int a=0;
        while(a<4){
            switch(a){
                case 0:;
                case 3:a=a+2;
                case 1:
                case 2:a=a+3;
                default:a=a+5;
            }
        }
        System.out.println(a);

    }

}
