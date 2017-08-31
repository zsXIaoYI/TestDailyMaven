package cn.zsza.dataStructure.array;

/**
 * Created by ZhangSong on 2017/8/28.
 * 16:50
 * V形数组，查找3元素
 */
public class ArraySearch {
    public static void main(String[] args) {
        int arr[] = {20, 19, 17, 15, 3, 6, 9, 12, 18, 24};

        int idx = search(arr);
        System.out.println(idx);

    }

    public static int search(int arr[]){
        int start = 0;
        int end = arr.length - 1;

        int midddle = (start + end) / 2;

        while (start < end){
            if (arr[midddle] < arr[midddle - 1] && arr[midddle] < arr[midddle + 1])
                return midddle;
            if (arr[midddle - 1] >= arr[midddle])
                start = midddle;
            if (arr[midddle + 1] >= arr[midddle])
                end = midddle;
            midddle = (start + end) / 2;
        }
        return 0;
    }
}
