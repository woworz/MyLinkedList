package com.my.Fater;


import com.my.LinkedList.JiangLinkedList;

import java.util.Iterator;
import java.util.Objects;

public class LinkedListFather {
    public int size=0;
    Node head = null;
    Node tail = null;

    public LinkedListFather() {

    }

    public void add(int index, Object obj) {
        if (index > size || index < 0) {
            return;
        }
        // 判断插入位置
        Node node = new Node(obj, null, null);
        Node temp;
        // 插入的是头部
        if (index == 0) {
            temp = this.tail;
            temp.next = node;
            node.previous = temp;
        }
        size++;
    }

    /**
     * Returns an iterator over the elements contained in this collection.
     */
    public Iterator iterator() {
        return null;
    }

    /**
     * Returns true if this collection contains the specified element.
     */
    public boolean contains(Object obj) {
        Iterator it = iterator();
        if (obj == null)
        {
            while (it.hasNext())
                if (it.next() == null)
                    return true;
        } else {
            while (it.hasNext())
                if (obj.equals(it.next()))
                    return true;
        }
        return false;
    }

    /***
     * Retains only the elements in this collection that are contained in the specified collection (optional operation).
     */
    public boolean remove(Object obj) {
        Iterator it = iterator();
        if (obj==null) {
            while (it.hasNext()) {
                if (it.next()==null) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public static class Node {
        Object item;
        Node next;
        Node previous;

        Node(Object item, Node previous, Node next) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

}
