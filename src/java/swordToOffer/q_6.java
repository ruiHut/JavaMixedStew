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
        listNode.addToTail(2);
        listNode.addToTail(3);
        listNode.addToTail(4);

        removeFirst(listNode, 0);
        removeFirst(listNode, 3);
        while (listNode != null) {
            System.out.println(listNode.getValue());
            listNode = listNode.pNext;
        }
    }

    public static void removeFirst(SingleListNode pHead, int value) {

        // 链表头为需删除节点
        if (pHead.getValue() == value) {
            SingleListNode pDelNode = pHead;
            pHead = pDelNode.pNext;
            pDelNode = null;
            return;
        }

        if (pHead.pNext == null)
            return;

        SingleListNode preNode = pHead;
        while (preNode.pNext != null) {
            SingleListNode delNode = preNode.pNext;
            if (delNode.getValue() == value) {
                preNode.pNext = delNode.pNext;
                delNode.pNext = null;
                return;
            } else {
                preNode = preNode.pNext;
            }
        }
    }
}

class SingleListNode {
    private int value;
    public SingleListNode pNext;

    SingleListNode(int value){
        this.value = value;
        pNext = null;
    }

    public boolean isEmpty() {
        return pNext == null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addToTail(int value) {
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