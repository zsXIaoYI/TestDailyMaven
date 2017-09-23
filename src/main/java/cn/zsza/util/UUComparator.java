package cn.zsza.util;

import cn.zsza.zs_base.entity.UU;

import java.util.Comparator;

/**
 * Created by ZhangSong on 2017/9/23.
 * 13:29
 */
public class UUComparator implements Comparator<UU> {
    /**
     * 比较器指定泛型是什么类型，则compare方法参数就是什么类型
     * 根据名字进行排序
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(UU o1, UU o2) {
        UU u1 =  o1;
        UU u2 =  o2;
        int num =  u1.getName().compareTo(u2.getName());
        if (num == 0){   // 名字相同，比较年龄
            if (u1.getAge() > u2.getAge()){
                return 1;
            }else if (u1.getAge() == u2.getAge()){
                return 0;
            }
            return -1;
        }
        return num;
    }
}
