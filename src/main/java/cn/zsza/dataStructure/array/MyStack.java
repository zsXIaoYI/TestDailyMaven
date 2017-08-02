package cn.zsza.dataStructure.array;

import java.util.Arrays;

/**
 * Created by ZhangSong on 2017/7/29.
 * 16:10
 */
public class MyStack<E> {
    private int size = 0;
    private Object array[];

    public MyStack(){
        this(10);
    }

    public MyStack(int init) {
        if (init <= 0){
            init = 10;
        }
        array = new Object[init];

    }
    /**
     * 入栈
     * @param item
     */
    public void push(E item){
        if (size == array.length){
            array = Arrays.copyOf(array,size * 2);
        }
        array[size++] = item;
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public E peek(){
        if(size == 0){
            throw new IndexOutOfBoundsException("stack is empty");
        }
        return (E) array[size - 1];
    }

    /**
     * 弹栈,同时获取栈顶元素
     * @return
     */
    public E pop(){
        E item = peek();
        size--;  // 使元素个数减一,不需要真的清除元素,下次入栈会覆盖
        return item;
    }

    /**
     * 栈是否满了
     * @return
     */
    public boolean isFull(){
        return size == array.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("栈顶\n");
        for (int i=size; i > 0;i--){
            sb.append(array[i-1] + "\n");
        }
        sb.append("栈底");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(2);

        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        System.out.println(stack.size());
    }

}
