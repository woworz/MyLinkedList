package com.my.test;
import com.my.LinkedList.*;

import java.util.ArrayList;


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
        System.out.println("Add�Ľ����"+ test);
    }
}