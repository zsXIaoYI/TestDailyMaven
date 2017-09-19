package cn.zsza.zs_base.entity;

import lombok.Data;

/**
 * Created by ZhangSong on 2017/9/19.
 * 11:34
 */
@Data
public class Node<T>{
    private T data;
    private Node next;

    public Node() {
    }

    public Node(T obj) {
        this.data = obj;
    }


}