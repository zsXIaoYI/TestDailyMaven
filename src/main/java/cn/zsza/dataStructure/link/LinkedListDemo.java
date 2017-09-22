package cn.zsza.dataStructure.link;

import cn.zsza.zs_base.entity.Node;
/**
 * Created by ZhangSong on 2017/5/2.
 * 20:43
 * 单向链表
 */
public class LinkedListDemo {
    private Node head;

    public LinkedListDemo() {
    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 尾插法
     * @param obj
     */
    public void add(Object obj){
        if (isEmpty()){
            head = new Node(obj);
        }else {
            Node current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new Node(obj));
        }
    }

    public int size(){
        int size = 0;
        Node current = head;

        while (current != null){
            size++;
            current = current.getNext();
        }
        return size;
    }
    public Object getElementAt(int index){
        Node reference = head;
        for (int i = 0; i < index; i++) {
            reference = reference.getNext();
        }
        return reference.getData();
    }

    public static void main(String[] args) {
        LinkedListDemo linkedListDemo = new LinkedListDemo();

        System.out.println("插入数据之前size:" + linkedListDemo.size());
        linkedListDemo.add("aa");
        linkedListDemo.add("bb");
        linkedListDemo.add("cc");
        linkedListDemo.add("dd");
        System.out.println("插入数据之后size:" + linkedListDemo.size());


        System.out.println(linkedListDemo.getElementAt(1));
    }
}
