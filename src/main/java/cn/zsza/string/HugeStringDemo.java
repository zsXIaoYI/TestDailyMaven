package cn.zsza.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2017/7/21.
 * 16:50
 */
public class HugeStringDemo {
    static class HugeStr{
        private String str = new String(new char[100000000]);

        public String getSubString(int begin,int end){
            return str.substring(begin,end);
        }
    }

    static class ImprovedHugeStr{
        private String str = new String(new char[10000000]);

        public String getSubString(int begin,int end){
            return new String(str.substring(begin,end));
        }
    }

    public static void main(String[] args) {
        List<String> handler = new ArrayList<>();

        for (int i = 0; i < 10000; i++){
            HugeStr h = new HugeStr();
            handler.add(h.getSubString(1,5));

//            ImprovedHugeStr h1 = new ImprovedHugeStr();
//
//            handler.add(h1.getSubString(1,5));
        }

        System.out.println("size:" + handler.size());
    }
}
