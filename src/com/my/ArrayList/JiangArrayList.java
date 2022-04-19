package com.my.ArrayList;

// import com.my.LinkedList.JiangLinkedList;

import java.util.Arrays;
import java.util.Objects;


public class JiangArrayList {
    private int size = 0;
    Node head = null;
    Node tail = null;
    protected transient int modCount = 0;

    /**
     * 将指定的元素追加到此列表的末尾。
     */
    public void add(Object obj) {
        Node node = new Node(obj, null, null);
        if (size == 0) {
            this.head = node;
        } else {
            Node temp;
            temp = this.tail;
            temp.next = node;
            node.previous = temp;
        }
        this.tail = node;
        size++;
    }

    /**
     * 在此列表中的指定位置插入指定元素。
     */
    public void add(int index, Object obj) {
        if(index > size || index < 0) {
            return;
        }
        if(index == size) {
            this.add(obj);
            return;
        }
        Node node = new Node(obj, null, null);
        Node temp;
        //插入的是头部
        if(index == 0) {
            temp = this.tail;
            temp.next = node;
            node.previous = temp;
        }
        //其它地方
        else {
            Node insert = indexOf(index);
            Node previous = insert.previous;
            node.previous = previous;
            node.next = insert; // 要注意此时的节点为inset
            previous.next = node;
            insert.previous = node;
        }
        size++;
    }

    /**
     * 从列表中移除所有元素。
     */
    public void clear() { // 清除让所有节点置空即可
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * 返回此ArrayList实例的浅层副本。
     */
    public Object clone() {
        try {
            JiangArrayList t = (JiangArrayList) super.clone();
            t.elementData = Arrays.copyOf(elementData, size);
            t.modCount = 0;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    /**
     * 存储ArrayList元素的数组缓冲区???
     */
    transient Object[] elementData;

    /**
     * 如果此列表包含指定的元素，则返回true。
     */
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /**
     * 返回此列表中指定位置的元素。
     */
    public Object get(int index) {
        if(index > size)
            return "error";
        return indexOf(index);
    }

    /**
     * 返回链表的大小
     */
    public int size() {
        return size;
    }

    /**
    * 定义节点内部静态类
     */
    private static class Node {
        Object item;
        Node next;
        Node previous;

        Node(Object item, Node previous, Node next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    /**
     * 查找指定元素
     */
    public Node indexOf(int index) {
        if(index == 0) {
            return head;
        } else if(index == size-1) {
            return tail;
        }
        Node n;
        if(index <= size/2) {
            n = head;
            for(int i = 1; i<index; i++) {
                n = head;
            }
        } else {
            n =tail;
            for(int i = size - 1; i >= index; i--) {
                n = n.previous;
            }
        }
        return n;
    }

    /**
     * 查找首个元素
     */
    public int indexOf(Object obj) {
        Node node = head;
        for(int i = 0; i<size; i++) {
            if (Objects.equals(node.item, obj)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    // 重写toString
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                str.append(node.item).append(",");
            } else {
                str.append(node.item);
            }
            node = node.next;
        }
        str.append("]");
        return str.toString();
    }
}
