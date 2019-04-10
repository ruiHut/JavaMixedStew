package swordToOffer;

// 基础知识之链表

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Stack;

//数据结构-单向链表
// struct ListNode
//  int value;
//  ListNode* m_pNext;
public class q_6 {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        reverseConsoleLinkedList(linkedList);
        reverseConsoleLinkedListByRecursion(linkedList);
    }

    // 从尾到头打印链表 栈
    private static void reverseConsoleLinkedList(SingleLinkedList linkedList) {
        Stack s = new Stack();
        for (int i = 0; i < linkedList.getLength(); i++) {
            s.push(linkedList.get(i));
        }
        for (int i = 0; i < linkedList.getLength(); i++) {
            System.out.println(s.pop());
        }
    }

    // TODO 从尾到头打印链表 递归 有待完成
    private static void reverseConsoleLinkedListByRecursion(SingleLinkedList linkedList) {
        while (head.nextNode != null) { // 终止条件
            reverseLinkedList(head.nextNode);
        }
        // 具体操作操作
        System.out.println(head.value);
    }
}

// 环形链表
class RingList {
    // 环形链表对象熟悉
    int length;
    Node head;
    Node last;


    // 链表基本数据结构
    class Node {
        int value;
        Node nextNode;

        Node (int value) {
            this.value = value;
        }
    }
}

// 单向链表
class SingleLinkedList {
    private int length;
    private SNode head;

    public SNode getHead() {
        return head;
    }

    public void setHead(SNode head) {
        this.head = head;
    }

    class SNode {
        int value;
        SNode nextNode;

        SNode(int value) {
            this.value = value;
        }

        SNode() {
        }
    }

    SingleLinkedList() {
        head = null;
        length = 0;
    }

    public void add(int value) {
        SNode node = new SNode(value);

        if (head == null) {
            head = node;

            length++;
            return;
        }

        SNode lastNode = getLastNode();
        lastNode.nextNode = node;

        length++;
    }

    public int getLength() {
        return length;
    }

    private SNode getLastNode() {
        SNode lastNode = head;
        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
        }
        return lastNode;
    }

    public int get(int index) {
        if (index < 0 && index > length)
            throw new IndexOutOfBoundsException("索引越界：index = " + index);

        SNode pNode = head;
        for (int i = 0; i < index; i++) {
            pNode = pNode.nextNode;
        }
        return pNode.value;
    }

    public int getValue(){
        return head.value;
    }
}

// 双向链表
class DoubleLinkedList {
    int length;
    Node head;

    class Node {
        int value;
        Node preNode;
        Node nextNode;

        Node(int value) {

        }
    }
}

// TODO 有待补充其他链表形式的数据结构