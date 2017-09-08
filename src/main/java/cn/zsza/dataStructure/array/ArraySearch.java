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

        int middle = (start + end) / 2;

        while (start < end){
            if (arr[middle] < arr[middle - 1] && arr[middle] < arr[middle + 1])
                return middle;
            if (arr[middle - 1] >= arr[middle])
                start = middle;
            if (arr[middle + 1] >= arr[middle])
                end = middle;
            middle = (start + end) / 2;
        }
        return 0;
    }
}
