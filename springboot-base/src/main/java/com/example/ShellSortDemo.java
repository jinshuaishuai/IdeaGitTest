package com.example;

/**
 * 希尔排序代码实现
 * @author shuai.jin
 * @date 2021/3/23 14:00
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        int[] arr = {10,100,100,1000,1,2,5};
        int gap = 1;
        while (gap < arr.length/3) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
