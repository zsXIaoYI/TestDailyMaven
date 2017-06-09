package cn.zsza.dataStructure.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2017/6/9.
 * 18:07
 */
public class SortTest {
    /**
     * 冒泡排序（升序）
     *  相邻的两个比较，如果前者比后者大，则交换
     */
    @Test
    public void testBubbleSort(){
        int array[] = new int[]{63,4,24,1,3,13};
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-i; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                System.out.print(array[j]+" ");
            }
            System.out.print("【");
            for (int j = array.length-i; j < array.length; j++) {
                System.out.print(array[j]+" ");
            }
            System.out.println("】");
        }
    }

    /**
     * 选择排序
     * 首先拿数组中第一个元素和剩下的其他元素进行比较，
     * 然后是第二个
     * ....,大则交换
     */
    @Test
    public void testSelectSort(){
        int array[] = new int[]{63,4,24,1,3,13};
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        List<Integer> list = new ArrayList<>();

        for (Integer in : array){
            list.add(in);
        }
        System.out.println(list);
    }

    @Test
    public void combineTwoArray(){
        /**
         *  pArray1和pArray2是已经排好序的数组,要求将它们按照顺序合并到pArray中
         */
        int pArray1[] = {2,3,5,7};
        int pArray2[] = {1,3,6,8,9};
        int i = 0,j=0,n=0;
        int nLen1 = pArray1.length;
        int nLen2 = pArray2.length;
        int pArray[] = new int[nLen1+nLen2];
        /**
         * 第一次循环 pArray1[0]<pArray2[0]，接下来是pArray1[1]<pArray2[0]
         * 也就是说，上一次的比较，哪个元素小，哪个数组的角标就往后挪1个位置
         * 极限情况：
         *    如果数组2中最小的元素都比数组1中最大的元素大，则数组1的角标则从0挪至length-1
         *    遍历整个数组1中的元素和数组2中角标为0的元素进行比较
         */
        while (i < nLen1 && j <nLen2){
            if (pArray1[i]<pArray2[j]){
                pArray[n++] = pArray1[i++];
            }else if (pArray1[i] > pArray2[j]){            // 拷贝array2的元素
                pArray[n++] = pArray2[j++];
            }else{                                          // 相等的元素拷贝
                int temp = pArray2[j++];
                pArray[n] = temp;                       // 当pArray1[1]=pArray2[1]时，把相等元素赋值给pArray[2],pArray[3]
                pArray[++n] = temp;
                n++;
                ++i;
            }
        }
        System.out.println("while循环结束");
        if (i == nLen1){                              // 如果array1已经被拷贝完毕就拷贝array2的元素
            while (j < nLen2)
                pArray[n++] = pArray2[j++];
        }else{                                         // 如果array2已经被拷贝完毕就拷贝array1的元素
            while (i < nLen1)
                pArray[n++] = pArray1[i++];
        }
        for(int k :pArray ){
            System.out.println("k="+k);
        }
    }
    /**
     * 二分查找
     */
    @Test
    public void testFindBinSearch(){
        int arr[] = new int[]{1,3,6,7,9,12};
        int start = 0;
        int end = arr.length - 1;   // end = 5
        int mid = arr.length / 2;
        int keyNum = 19;   // 设置要查找的数为7
        if(arr[mid]==keyNum){
            System.out.println("一下就找到了");
            return;
        }
        while (start<=end){
            if (keyNum > arr[mid]){   // 要找的元素在数组的下半部分
                start = mid + 1;
            }else if (keyNum < arr[mid]){
                end = mid -1;
            }else {
                System.out.println("找到了");
                break;
            }
            mid = (end + start) / 2;
        }
    }
    /**
     * 插入排序 从数组第一个元素开始，相邻之间进行比较
     *   即第一个比第二个大则赋值temp为较小的元素
     *   时间复杂度：O（n^2）,特别情况下， 当所要排序的数据是有序的情况下，时间复杂度变为更好的O(n);
     *   空间复杂度：O（1）；
     */
    @Test
    public void insertSort(){
        int values[] = {2,5,4,1,3};
        int temp;
        int j = 0;
        for (int i = 1; i < values.length; i++) {
            if(values[i]<values[i-1]){       //此处的判断很重要，这里体现了插入排序比冒泡排序和选择排序快的原因。
                temp = values[i];
                /**
                 * 数据往后移动，比如2,5已排序好，接下来的代码是把4插入到2,5之间
                 */
                for (j=i-1; j>=0 && temp<values[j]; j--){
                    values[j+1] =values[j];          // 把前一个元素赋值为后一个元素，如把第二个元素的值赋值到第三个
                }
                //将数据插入到j+1位置
                values[j+1] =temp;
                System.out.print("第" + (i + 1) + "次：");
                for (int k = 0; k < values.length; k++) {
                    System.out.print(values[k]+",");
                }
                System.out.println("");
            }
        }
    }

}
