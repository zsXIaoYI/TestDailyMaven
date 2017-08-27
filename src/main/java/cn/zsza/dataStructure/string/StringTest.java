package cn.zsza.dataStructure.string;

import cn.zsza.util.StringUtils;
import org.junit.Test;

/**
 * Created by ZhangSong on 2017/8/27.
 * 21:31
 */
public class StringTest {
    /**
     * 判断字符串是否为回文串
     */
    @Test
    public void test1(){
        System.out.println(StringUtils.isPalindrome("abcdcba"));
        System.out.println(StringUtils.isPalindrome("abcdhba"));
    }

    /**
     * 字符串全全组合
     */
    @Test
    public void test2(){
        String[] str = {"a" , "b" ,"c"};
        int n = str.length;                                  //元素个数。
        //求出位图全组合的结果个数：2^n
        int nbit = 1<<n;                                     // “<<” 表示 左移:各二进位全部左移若干位，高位丢弃，低位补0。:即求出2^n=2Bit。
        System.out.println("全组合结果个数为："+nbit);

        for(int i=0 ;i<nbit ; i++) {                        //结果有nbit个。输出结果从数字小到大输出：即输出0,1,2,3,....2^n。
            System.out.print("组合数值  "+i + " 对应编码为： ");
            for(int j=0; j<n ; j++) {                        //每个数二进制最多可以左移n次，即遍历完所有可能的变化新二进制数值了
                int tmp = 1<<j ;
                if((tmp & i)!=0) {                            //& 表示与。两个位都为1时，结果才为1
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
}
