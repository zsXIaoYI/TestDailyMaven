package cn.zsza.dataStructure.array;

import java.util.Arrays;

/**
 * Created by ZhangSong on 2017/9/29.
 * 18:27
 */
public class ArrayOddAndEven {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        reOrderOddAnaEvem(arr);

        Arrays.stream(arr).forEach(e ->
                System.out.print(e +" "));

    }

    private static void reOrderOddAnaEvem(int[] arr) {
        if (arr == null || arr.length < 0){
            throw new RuntimeException("invalid array");
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            while (start < end && arr[end] % 2 == 0)
                end--;
            while (start < end && arr[start] % 2 == 1)
                start++;
            if (start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

    }
}
