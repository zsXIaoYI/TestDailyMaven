package cn.zsza.dataStructure.link;

import cn.zsza.zs_base.entity.Node;

/**
 * Created by ZhangSong on 2017/9/19.
 * 11:25
 */

public class MyLink<T> {

    private int size = 0;
    private Node first;
    private Node last;

    public MyLink() {
    }

    /**
     * 尾插法插入
     * @param data
     */
    public void addLast(T data){
        if (size == 0){
            fillStart(data);
        }else {
            Node node = nodeData(data);
            last.setNext(node);
            last = node;
        }
        size ++;
    }
    /**
     * 头插法
     * @param data
     */
    public void addFirst(T data){
        if (size == 0){
            fillStart(data);
        }else {
            Node node = nodeData(data);
            node.setNext(first);
            first = node;
        }
        size ++;
    }
    /**
     * 在链表指定的位置后面插入
     * @param data 需要插入的数据
     * @param index 下标从0开始
     */
    public void add(T data,int index){
        if(size > index){
            if (size == 0){
                fillStart(data);
                size ++;
            }else if (index == 0){
                addFirst(data);
            }else if (size == index + 1){
                addLast(data);
            }else {
                Node temp = get(index);
                Node node = new Node();
                node.setData(data);
                node.setNext(temp.getNext());
                temp.setNext(node);
                size ++;
            }
        }else {
            throw new IndexOutOfBoundsException("超出了链表的长度");
        }
    }

    /**
     * 删除链表头部元素
     */
    public void removeFirst(){
        if (size == 0){
            throw new IndexOutOfBoundsException("链表没有元素");
        }else if (size == 1){  // 只有一个元素
            clear();
        }else {
            Node temp = first;
            first = temp.getNext();
            temp = null;
            size --;
        }
    }

    /**
     * 删除链表尾部元素
     */
    public void removeLast(){
        if (size == 0){
            throw new IndexOutOfBoundsException("链表没有元素");
        }else if (size == 1){
            clear();
        }else if (size == 2){
            last = first;
            size = 1;
        } else {
            Node temp = get(size - 2);
            temp.setNext(null);
            size --;
        }
    }

    /**
     * 在链表只有一个时，清楚first和last
     */
    private void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * 获取指定下标元素
     * @param index
     * @return
     */
    public Node get(int index) {
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    private Node nodeData(T data){
        Node node = new Node();
        node.setData(data);
        return node;
    }

    private void fillStart(T data) {
        first = new Node();
        first.setData(data);
        last = first;
    }
}
