package cn.zsza.dataStructure.array;

/**
 * Created by zs on 2017/7/29.
 * 14:45
 */
public class MyArrayList<E> {

    private static final int INITIAL_SIZE = 10;
    private int size = 0;

    private Object[] array;

    public MyArrayList() {
        array = new Object[INITIAL_SIZE];
    }

    public MyArrayList(int initial){
        if (initial <= 0){
            initial = INITIAL_SIZE;
        }
        array = new Object[initial];
    }

    public void add(){}
}
