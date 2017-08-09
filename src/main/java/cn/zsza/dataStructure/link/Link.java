package cn.zsza.dataStructure.link;

/**
 * Created by ZhangSong on 2017/5/2.
 * 22:27
 * Link代表一本书的名字和销量
 */
public class Link {
    public String bookName;
    public int millionsSold;

    public Link next;

    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    @Override
    public String toString() {
        return "Link{" +
                "bookName='" + bookName + '\'' +
                '}';
    }

    public void display(){
        System.out.println(bookName + "...." + millionsSold);
    }

    /**
     *
     * @param args
     * 头插法
     * LinkList:
       初始化 first为null
       插入一个新节点,first后移,newLink.next = first;
       把newLink作为头结点,first = newLink;
     */

    public static void main(String[] args) {
        LinkList theLinkedList = new LinkList();
        theLinkedList.insertfirst2("java",200);
        theLinkedList.insertfirst2("php",100);
        theLinkedList.insertfirst2("python",80);
        theLinkedList.insertfirst2("C++",60);

//        theLinkedList.insertlast("java",200);
//        theLinkedList.insertlast("php",100);
//        theLinkedList.insertlast("python",80);
//        theLinkedList.insertlast("C++",60);

//        theLinkedList.removefirst();
        theLinkedList.display();
    }
}
class LinkList{
    public Link first;  // 头节点

    public Link last;   // 尾节点

    public int size;

    public LinkList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }
    /**(第一个版本不考虑尾节点)
     * 新加入的节点放入链表的头部
     * 链表初始化，first = null
     * 加入第一个节点:newLink.next = first, 新的节点.next指向first
     * 然后把新加入的节点作为first:first = newLink
     * @param bookName
     * @param millionsSold
     */

    public void insertfirst(String bookName, int millionsSold){
        Link newLink = new Link(bookName, millionsSold);
        newLink.next = first;
        first = newLink;
    }
    /**
     * 考虑尾节点
     * @param bookName
     * @param millionsSold
     */
    public void insertfirst2(String bookName, int millionsSold){
        Link newLink = new Link(bookName, millionsSold);
        if (size == 0){
            fillStart(newLink);
        }else {
            newLink.next = first;
            first = newLink;
        }
        size++;
    }

    private void fillStart(Link link) {
        first = link;
        last = first;
    }

    public void insertlast(String bookName, int millionsSold){
        Link newLink = new Link(bookName, millionsSold);
        if (first == null){
            first = newLink;
            last = first;
        }else {
            last.next = newLink;
            last = newLink;
        }
    }

    /**
     * 移除头元素,然后把first.next指向first
     * @return
     */
    public Link removefirst(){
        Link linkReference = first;
        if (!isEmpty()){
            first = first.next;
        }else {
            System.out.println("empty link");
        }

        return linkReference;
    }

    public void display(){
        Link theLink = first;

        while (theLink != null){
            System.out.println("Next link:" + theLink.next);
            theLink.display();
            theLink = theLink.next;
            System.out.println();
        }
    }
    public Link find(String bookName){
        Link theLink = first;
        if (!isEmpty()){
            while (theLink.bookName != bookName){
                if (theLink.next == null){
                    return null;
                }else {
                    theLink = theLink.next;
                }

            }
        }else {
            System.out.println("empty link");
        }
        return theLink;
    }

    public Link removeLink(String bookName){
        Link currentLink = first;
        Link previousLink = first;

        while (currentLink.bookName != bookName){
            if (currentLink.next == null){
                return null;
            }else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if (currentLink == first){
            first = first.next;
        }else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }
}
