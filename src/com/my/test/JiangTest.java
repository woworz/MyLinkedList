package com.my.test;
import com.my.ArrayList.JiangArrayList;
import com.my.LinkedList.*;

import java.util.Objects;

public class JiangTest {
    public static void main(String[] args) {
        JiangLinkedList test = new JiangLinkedList();
        test.add("嗯哼哼");
        test.add(1, "没有斯琴高娃老师最近打了羊胎素了");
        test.add(2, "这是可以说的吗");
        test.addFirst("那斯琴高娃老师知道袁立怀孕了会给她支点招吗");
        test.addLast("哦");
        test.offer("可以的可以的");
        test.removeFirst();
        test.pop();
        test.push("她需要的话");
        System.out.println("LinkedList的结果："+ test);
        JiangArrayList test2 = new JiangArrayList();
        test2.add("欧豪，我是V神");
        test2.add(1,"但今天晚上");
        System.out.println("ArrayList的结果："+ test2);
        System.out.println(test2.get(0));
    }
}