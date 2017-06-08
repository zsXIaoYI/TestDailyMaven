package cn.zsza;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by user on 2016/2/29.
 */


public class Exercise_Daily {
    int sum;
    /**
     * for循环的执行顺序
     */
    @Test
    public void testFor(){
        for (int i = 1,j=i+1; i < 5; i++,j=i*2) {   // i、j只初始化一次
            if(j<7)
                System.out.println("i="+i+",j="+j);
        }
    }
    @Test
    public void testBreak1(){
        System.out.println("-----测试break1------");
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                if(i==3)
                    break;
                System.out.println("i="+i);
            }
            System.out.println("j="+j);
        }
    }
    @Test
    public void testBreak2(){
        System.out.println("------测试break2--------");
        int i = 1;
        int k = 4;
        lable1:for (; i <= 5; i++, k--) {
            if (k == 0)
                break lable1;
            System.out.println("i=" + i + " ; k=" + k);
        }
    }
    @Test
    public void testContinue1(){
        System.out.println("---------测试continue1-----------");
        for (int i = 0; i < 5; i++) {
            if(i==3)
                continue;
            System.out.println("i="+i);
        }
    }
    @Test
    public void testContinue2(){
        System.out.println("-------测试Continue2----------");
        lable1:for (int i = 0; i < 5; i++) {
//            System.out.println("i1="+i);
            for (int j = 0; j < 5; j++) {
                if(j==3)
                    continue lable1;
            }
            System.out.println("i="+i);
        }
    }
    /**
     * 闰年的判断规则如下： 若某个年份能被 4 整除但不能被 100 整除，则是闰年。
     * 若某个年份能被 400 整除，则也是闰年。
     * 闰年：leapyear
     */
    @Test
    public void testLeapYear() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个年份:");
        int year = sc.nextInt();
        while (year < 0 || year > 3000) {
            System.out.println("年份输入有误，请重新输入~！");
            year = sc.nextInt();
            continue;
        }
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 4 == 0)) {
            System.out.println("是闰年");
        } else
            System.out.println("不是闰年");
    }

    /**
     * 递归求1+2+3+....+n=?
     */
    @Test
    public void testRecursion(){
        int n = 3;
        int tSum = iSum(n);
        System.out.println("1+2+...+n的和为："+tSum);
    }
    public int iSum(int n){
        sum += n;
        sum = n==0?sum:iSum(--n);
        return sum;
    }
    @Test
    public void test11(){
        String str = "0.001";
        BigDecimal bd1 = new BigDecimal(Double.valueOf(str).doubleValue());
        BigDecimal bd2 = bd1.setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println("=="+bd2);
    }
    /**
     * 控制台输出菱形
     */
    @Test
    public void testLozenge(){
        int floor = 9;
        floor = floor%2==0?floor+1:floor;
        System.out.println("floor="+floor);

        for (int i = 0; i < (floor+1)/2+1; i++) {
            for (int j = 1; j < (floor+1)/2+1-i; j++) {   //当 i=？ 空格循环的次数
                System.out.print(" ");
            }
            for (int k = 0; k < 2*i+1; k++) {    //当 i=？ *循环的次数
                System.out.print("♥");
            }
            System.out.println();
        }

        for (int i = 0; i < (floor+1)/2; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < floor-2*i ; k++) {
                System.out.print("♥");
            }
            System.out.println();
        }
    }
    /**
     * 跳出当前的多重嵌套循环
     */
    @Test
    public void testBreakForFor(){
        label:
        for (int i = 1; i < 5; i+=2) {
            for (int j = 7; j > i-1; j--) {
                System.out.println("j="+j);
                if(j==5){
                    //break label;
                    continue label;
                }
            }
        }
        System.out.println("我跳出了双层for循环");
    }
    int i;
    @Test
    public void testForVariable(){
        for (int i = 0; i < 10; i++) {
            i++;
            System.out.println(i);
        }
        System.out.println("I="+i);
    }
    /**
     * 将数组1中，从第六个元素开始，复制到数组2中
     */
    @Test
    public void testArrayCopy(){
        int arr1[] = {1,2,3,4,5,
                6,7,8,9,10,
                11,12,13,14,15,16,17};
        int arr2[] = new int[arr1.length-5];
        for (int i = 5; i < arr1.length; i++) {
            arr2[i-5] = arr1[i];
        }

        for (int i = 1; i <= arr2.length; i++) {
            if(i%5==0||i==arr2.length){    // 5个一行输出到控制台
                System.out.println(arr2[i-1]);
            }else{
                System.out.print(arr2[i-1]+",");
            }
        }
    }
    @Test
    public void testArrayCopy2(){
        int arr1[] = {1,2,3,4,5,
                6,7,8,9,10,
                11,12,13,14,15,16,17};
        int arr2[] = Arrays.copyOfRange(arr1, 5, arr1.length);

        for (int i = 1; i <= arr2.length; i++) {
            if(i % 5 == 0 || i == arr2.length){    // 5个一行输出到控制台
                System.out.println(arr2[i-1]);
            }else{
                System.out.print(arr2[i-1]+",");
            }
        }
    }
    /**
     * 求一维数组中的最大值和最小值
     *
     */
    @Test
    public void testMaxAndMinOfArray(){
        int arr[] = {23,56,17,100,55,60};
        int max = 0;
        int min = 0;
        if(arr.length>0){
            max = arr[0];
            min = arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("数组中最大的数是："+max);
        System.out.println("数组中最小的数是："+min);
    }
    /**
     * 数组中的查找
     * Arrays.binarySearch()
     */
    @Test
    public void testBinarySearch(){
        int arr[] = {23,56,17,100,55,60};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int index = Arrays.binarySearch(arr, 55);
        if(index>0){
            System.out.println("55找到了");
        }else{
            System.out.println("55没找到");
        }
    }


    /**
     * 直接插入排序
     *
     */
	/*  {40,90,30,80,50}
	 * 当i=1时，tmp =90
       j=0  j>=0&& a[0]>tmp 不成立  不交换  {40,90,30,80,50}
   当i=2时，tmp =30
       j=1  j>=0&& a[1]>tmp  成立     交换  {40,30,90,80,50};
       j=0  j>=0&& a[0]>tmp  成立     交换  {30,40,90,80,50};
   当i=3时，tmp =80
       j=2, j>=0&& a[2]>tmp  成立           {30,40,80,90,50};
       j=1, j>=0&& a[1]>tmp 不成立
       j=1, j>=0&& a[0]>tmp 不成立
   当i=4时，tmp=50
       j=3, j>=0&& a[3]>tmp  成立        {30,40,80,50,90};
       j=2, j>=0&& a[2]>tmp  成立        {30,40,50,80,90};
	 */
    @Test
    public void testInsertSort(){
        int array[] = new int[]{40,90,30};
        System.out.println("排序前：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int tmp;
        int j;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            for (j = i-1; j >= 0&&array[j]>tmp ; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = tmp;
        }
        System.out.println("排序后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    @Test
    public void testOneArrayMemory(){
        int num = 1024*1024*2;
        int arr[] = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        long memory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        System.out.println("占用内存量为："+memory);
    }
    @Test
    public void testTwoArrayMemory(){
        int num = 1024*1024;
        int arr[][] = new int[num][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[i][1] = i;
        }
        long memory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        System.out.println("占用内存量为：" + memory);
    }
    @Test
    public void testFillArray1(){
        int arr[] = new int[5];
        Arrays.fill(arr, 3);

        for(int i:arr){
            System.out.println("第"+i+"个元素是："+arr[i]);
        }
    }
    @Test
    public void testChuFa() throws UnsupportedEncodingException{
        String str = "安康";
        str = URLEncoder.encode(str, "GBK");
        System.out.println(str);

    }
    @Test
    public void testMap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xiaosi");
        map.put("age", "12");
        System.out.println("map="+map);

        System.out.println("7.9".compareTo("7.8"));
    }
    @Test
    public void testRandom(){
        int random = (int)(Math.random() * 1000);  // 返回一个随机的三位数
        System.out.println(random);
    }
    @Test
    public void testClassLoader(){
        ClassLoader classLoader = Exercise_Daily.class.getClassLoader();
        System.out.println("...."+classLoader.toString());
    }
    @Test
    public void testInterview(){
        int a = 1,b = 1,c = 1,d = 1;
        a++;
        ++b;
        c = c++;    // 直接赋值
        d = ++d;    // 先加后赋值
        System.out.println(a + "," + b + "," + c + "," + d);
    }
    @Test
    public void  testInteger(){
        System.out.println("..."+Integer.MAX_VALUE);
        System.out.println("..."+Integer.MIN_VALUE);
    }
    @Test
    public void testSwitch(){
        String str = "a";

        switch (str){
            case "a":
                System.out.println("aaa");
                break;
            case "b":
                System.out.println("bbb");
                break;
            default:
                System.out.println("biubiu");
        }
    }

    @Test
    public void testEquals(){
        Exercise_Daily ee = new Exercise_Daily();
        Exercise_Daily ff = new Exercise_Daily();

        Exercise_Daily gg = ee;



        System.out.println(ee.equals(ff));
        System.out.println(ee.equals(gg));
        System.out.println(ee == ff);

    }

    /**
     * 位运算
     * 位运算
     */
    @Test
    public void testBit(){
        int a = 8;
        int b = a << 1;   // 左移操作，乘以2
        int c = a >> 1;   // 右移操作，除以2
        System.out.println("b=" + b);
        System.out.println("c=" + c);

        int d = 8 & 6;   // 与操作
        int e = 8 | 6;   // 或操作
        int f = ~ 2;     // 非操作
        int g = 8 ^ 6;    // 异或操作
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
    }

}