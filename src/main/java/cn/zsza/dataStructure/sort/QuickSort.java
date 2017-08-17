package cn.zsza.dataStructure.sort;
/**
 * Created by user on 2016/7/19.
 * 快速排序
 * 不稳定排序
 */
class sortTool{
    public static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot = partition(arr, low, high);        //将数组分为两部分
            System.out.println("pivot="+pivot);
            qsort(arr, low, pivot-1);                   //递归排序左子数组
            qsort(arr, pivot+1, high);                  //递归排序右子数组
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot)   // 当high元素大于枢轴，high一直向前移动
                --high;
            arr[low]=arr[high];                    //当high元素小于枢轴，交换比枢轴小的记录到左端
            while (low<high && arr[low]<=pivot)
                ++low;
            arr[high] = arr[low];           //交换比枢轴大的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
}

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {49,38,65,12,4};
        sortTool st = new sortTool();
        st.qsort(a, 0, a.length - 1);
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
