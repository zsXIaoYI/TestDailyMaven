package cn.zsza;

/**
 * Created by ZhangSong on 2017/9/19.
 * 10:04
 *
 * （1）基本数据类型传值，对形参的修改不会影响实参；
 * （2）引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象；
 * （3）String, Integer, Double等immutable的类型特殊处理，可以理解为传值，最后的操作不会修改实参对象。
 */
class MyObj{
    public int b = 99;
}
public class ReferencePkValue2 {
    public void test1(int a){
        a = a + 1;
        System.out.println(a);
    }
    public void test2(MyObj obj){
        obj.b = 100;
        System.out.println(obj.b);
    }

    public void change(String str){
        str = str + "world";
    }
    public void change(StringBuffer sb){
        sb.append("world");
    }

    public static void main(String[] args) {
        ReferencePkValue2 t = new ReferencePkValue2();

        int a = 99;
        t.test1(a);
        System.out.println("a=" +a);

        MyObj obj = new MyObj();
        t.test2(obj);
        System.out.println("obj.b=" +obj.b);
        System.out.println("...........String...........");

        String str = "Hello";
        t.change(str);
        System.out.println("str:" +str);

        StringBuffer sb= new StringBuffer("Hello ");
        t.change(sb);
        System.out.println(sb.toString());
    }
}
