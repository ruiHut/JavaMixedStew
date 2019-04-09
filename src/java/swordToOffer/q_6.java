package swordToOffer;

// 基础知识之链表

import com.sun.xml.internal.bind.v2.TODO;

//数据结构-单向链表
// struct ListNode
//  int value;
//  ListNode* m_pNext;
public class q_6 {
    public static void main(String[] args) {
        SingleListNode listNode = new SingleListNode(0);
        listNode.addToTail(1);

        while (listNode != null) {
            System.out.println(listNode.getValue());
            listNode = listNode.getPNext();
        }
    }
}

class SingleListNode<T> {
    private T value;
    private SingleListNode<T> pNext;

    SingleListNode(T value){
        this.value = value;
        pNext = null;
    }

    public boolean isEmpty() {
        return pNext == null;
    }

    public T getValue() {
        return value;
    }

    public SingleListNode getPNext() {
        return pNext;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void addToTail(T value) {
        SingleListNode tailNode = getTailNode();

        SingleListNode newNode = new SingleListNode(value);
        tailNode.pNext = newNode;
    }

    private SingleListNode getTailNode() {
        SingleListNode pHead = SingleListNode.this;

        while(pHead.pNext != null)
            pHead = pHead.pNext;

        return pHead;
    }
}