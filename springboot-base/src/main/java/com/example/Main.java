package com.example;

import java.util.Scanner;

/**
 * @author shuai.jin
 * @date 2020/9/7 9:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int count = 0;
        while ((n = sc.nextInt()) != 0) {
            int sum = 0;
            for(int i = (n % 2 == 0 ? (n / 2) : (n / 2) + 1);i >= 1; i--) {

                if(sum == n) {
                    count ++;
                    sum = 0;
                }
                sum += i;
            }
            System.out.println(count);
            count = 0;
        }

    }

}
