package swordToOffer;

// 基础知识之链表

//数据结构-单向链表
// struct ListNode
//  int value;
//  ListNode* m_pNext;
public class q_6 {
    public static void main(String[] args) {
        SingleListNode listNode = new SingleListNode(0);
//        listNode.addToTail(1);

        while (listNode != null) {
            System.out.println(listNode.getValue());
            listNode = listNode.pNext;
        }
    }
}

class SingleListNode<T> {
    private T value;
    public SingleListNode<T> pNext;

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

    public void setValue(T value) {
        this.value = value;
    }

    // TODO 有待实现一个添加在链表末尾添加新链表的方法

//    public void addToTail(T value) {
//        SingleListNode tailNode = getTailNode();
//
//        SingleListNode newNode = new SingleListNode(value);
//        tailNode.pNext = newNode;
//    }
//
//    private SingleListNode getTailNode() {
//        SingleListNode pHead = SingleListNode.this;
//        while(pNext != null)
//            pNext = pNext.pNext;
//
//        return pNext;
//    }
}