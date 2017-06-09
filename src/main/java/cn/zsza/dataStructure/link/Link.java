package cn.zsza.dataStructure.link;

/**
 * Created by ZhangSong on 2017/5/2.
 * 22:27
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

    public static void main(String[] args) {
        LinkList theLinkedList = new LinkList();
        theLinkedList.insertFirstLink("java",200);
        theLinkedList.insertFirstLink("php",100);
        theLinkedList.insertFirstLink("python",80);
        theLinkedList.insertFirstLink("C++",60);

        theLinkedList.display();
    }
}

class LinkList{
    public Link firstLink;

    public LinkList() {
        this.firstLink = null;
    }

    public boolean isEmpty(){
        return firstLink == null;
    }

    public void insertFirstLink(String bookName, int millionsSold){
        Link newLink = new Link(bookName, millionsSold);

        newLink.next = firstLink;

        firstLink = newLink;

    }

    public Link removeFirstLink(){
        Link linkReference = firstLink;
        if (!isEmpty()){
            firstLink = firstLink.next;
        }else {
            System.out.println("empty link");
        }

        return linkReference;
    }

    public void display(){
        Link theLink = firstLink;

        while (theLink != null){
            theLink.display();
            System.out.println("Next link:" + theLink.next);

            theLink = theLink.next;
            System.out.println();
        }
    }
    public Link find(String bookName){
        Link theLink = firstLink;
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
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while (currentLink.bookName != bookName){
            if (currentLink.next == null){
                return null;
            }else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if (currentLink == firstLink){
            firstLink = firstLink.next;
        }else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }
}
