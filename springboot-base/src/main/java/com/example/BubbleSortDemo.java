package com.example;

/**
 * 冒泡排序代码实现
 * @author shuai.jin
 * @date 2021/3/23 10:40
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {10,100,100,1000,1,2,5};
        for(int i = 0; i < arr.length - 1; i ++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i]);
        }
    }
}
