package com.my.test;
import com.my.ArrayList.JiangArrayList;
import com.my.LinkedList.*;

import java.util.Objects;

public class JiangTest {
    public static void main(String[] args) {
        JiangLinkedList test = new JiangLinkedList();
        test.add("�źߺ�");
        test.add(1, "û��˹�ٸ�����ʦ���������̥����");
        test.add(2, "���ǿ���˵����");
        test.addFirst("��˹�ٸ�����ʦ֪��Ԭ�������˻����֧������");
        test.addLast("Ŷ");
        test.offer("���ԵĿ��Ե�");
        test.removeFirst();
        test.pop();
        test.push("����Ҫ�Ļ�");
        System.out.println("LinkedList�Ľ����"+ test);
        JiangArrayList test2 = new JiangArrayList();
        test2.add("ŷ��������V��");
        test2.add(1,"����������");
        System.out.println("ArrayList�Ľ����"+ test2);
        System.out.println(test2.get(0));
    }
}