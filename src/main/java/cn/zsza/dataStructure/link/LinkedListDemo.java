package cn.zsza.dataStructure.link;

/**
 * Created by ZhangSong on 2017/5/2.
 * 20:43
 */
class Node<T>{
    private T value;
    private Node next;

    public Node(T obj) {
        this.value = obj;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}

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
    public void add(Object obj){
        System.out.println("add");
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
        return reference.getValue();
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
