package com.my.LinkedList;

import com.my.Fater.LinkedListFather;
import java.util.Objects;

public class JiangLinkedList extends LinkedListFather{
    private int size = 0;
    Node head = null;
    Node tail = null;

    public JiangLinkedList() {
        super();
    }


    /**
     * Appends the specified element to the end of this list.
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
     * Inserts the specified element at the specified position in this list.
     */
    public void add(int index, Object obj) {
        /*
         * ���������Ϸ�ʱ���������򱨴�
         * Exception in thread "main" java.lang.NullPointerException
         * ���ᵼ���������Ϸ��������������
         */
        if (index > size || index < 0) {
            return;
        }
        // �жϲ���λ��
        if (index == size) {
            this.add(obj);
            return;
        }
        Node node = new Node(obj, null, null);
        Node temp;
        // �������ͷ��
        if (index == 0) {
            temp = this.tail;
            temp.next = node;
            node.previous = temp;
        }
        // ���������ط�
        else {
            Node insert = indexOf(index);
            Node previous = insert.previous;
            node.previous = previous;
            node.next = insert;
            previous.next = node;
            insert.previous = node;
        }
        size++;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     */
    public void addFirst(Object obj) {
        Node node = new Node(obj, null, null);
        Node temp = this.head;
        this.head = node;
        node.next = temp;
        temp.previous = node;
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     * ��������ӵ�����������ֱ�ӵ���add
     */
    public void addLast(Object obj) {
        add(size, obj);
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     */
    public void remove() {
        remove(0);
    }

    /**
     * Removes the element at the specified position in this list.
     */
    public void remove(int index) {
        Node n;
        if (index == 0)
        {
            n = head.next;
            head = n;
            n.previous = null;
        } else if (index == size - 1) {
            n = tail.previous;
            tail = n;
            n.next = null;
        } else {
            Node node = indexOf(index);
            Node previous = node.previous;
            Node next = node.next;
            previous.next = next;
            next.previous = previous;
        }
        size--;
    }

    /**
     * Removes and returns the first element from this list.
     */
    public Object removeFirst() {
        remove(0);
        return null;
    }

    /**
     * Removes and returns the last element from this list.
     */
    public void removeLast() {
        int index = size;
        remove(index);
    }

    /**
     * Returns true if this list contains the specified element.
     */
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /**
     * Returns the element at the specified position in this list.
     * ��Ҳ��֪��Ϊʲô�ַ�����hashCode
     */
    public Node get(int index) {
        return indexOf(index);
    }

    /**
     * Adds the specified element as the tail (last element) of this list.
     * ��addLast�������ƣ�ֱ�ӵ��þ���
     */
    public void offer(Object obj) {
        addLast(obj);
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     */
    public void poll() {
        if (head != null)
            remove(0);
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        this.tail = null;
        this.head = null;
        size = 0;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     */
    public void set(int index, Object obj) {
        // �ж������Ƿ�Ϸ�
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        indexOf(index).item = obj;
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Pops an element from the stack represented by this list.
     * In other words, removes and returns the first element of this list.
     */
    public Object pop() {
        return removeFirst();
    }

    /**
     * Pushes an element onto the stack represented by this list.
     * In other words, inserts the element at the front of this list.
     */
    public void push(Object obj) {
    addFirst(obj);
    }

    // �����׸�Ԫ��
    public int indexOf(Object obj) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.item, obj)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    // ����ָ������Ԫ��
    public Node indexOf(int index) {
        if (index == 0) {
            return head;
        }
        if (index == size - 1) {
            return tail;
        }
        Node n;
        if (index <= size / 2) {
            n = head;
            for (int i = 1; i < index; i++) {
                n = n.next;
            }
        } else {
            n = tail;
            for (int i = size - 1; i >= index; i--) {
                n = n.previous;
            }
        }
        return n;
    }

    // ����ڵ��ڲ���̬��
    private static class Node {
        Object item;
        Node next;// ��һ����ַ
        Node previous;  //��һ����ַ

        Node(Object item, Node previous, Node next) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    //��дtoString
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

