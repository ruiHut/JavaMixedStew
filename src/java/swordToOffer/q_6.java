package swordToOffer;

// 基础知识之链表

import com.sun.xml.internal.bind.v2.TODO;

//数据结构-单向链表
// struct ListNode
//  int value;
//  ListNode* m_pNext;
public class q_6 {
    public static void main(String[] args) {

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
class singleLinkedList {
    int length;
    Node head;

    class Node {
        int value;
        Node nextNode;

        Node (int value) {
            this.value = value;
        }
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