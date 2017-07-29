package cn.zsza.dataStructure.array;

import java.util.Arrays;
/**
 * Created by zs on 2017/7/29.
 * 14:45
 */
public class MyArrayList<E> {

    private static final int INITIAL_SIZE = 10;
    private int size = 0;
    private Object[] array;

    /**
     * 默认容量为10
     */
    public MyArrayList() {
        array = new Object[INITIAL_SIZE];
    }

    public MyArrayList(int initial){
        if (initial <= 0){
            initial = INITIAL_SIZE;
        }
        array = new Object[initial];
    }

    /**
     * 添加元素
     * @param val
     */
    public void add(E val){
        if (size == array.length){
            array = Arrays.copyOf(array,size * 2);
        }
        array[size++] = val;
    }
    /**
     * 获取指定位置元素的值
     * @param i
     * @return
     */
    public E get(int i){
        if (i >= size){
            throw new IndexOutOfBoundsException("out of Bounds exception");
        }
        return (E) array[i];
    }

    /**
     * 设置指定位置的元素的值
     * @param i
     * @param val
     * @return
     */
    public E set(int i, E val){
        E oldVal = get(i);
        array[i] = val;
        return oldVal;
    }

    /**
     * 获取长度
     * @return
     */
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size; i++){
            if (i == size - 1){
                sb.append(array[i]);
            }else {
                sb.append(array[i] + ",");
            }

        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("list:" + list.toString());
        System.out.println(list.get(3));

        list.set(3,9);
        System.out.println(list.get(3));

        System.out.println(list.size());
    }
}
