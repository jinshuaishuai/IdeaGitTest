package com.example;

/**
 * 选择排序代码实现
 * @author shuai.jin
 * @date 2021/3/23 10:34
 */
public class SelectSortDemo {

    public static void main(String[] args) {
        int[] arr = {10,100,1000,1,2,5};
        for(int i = 0; i < arr.length - 1; i ++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //如果找到了最小值
            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
