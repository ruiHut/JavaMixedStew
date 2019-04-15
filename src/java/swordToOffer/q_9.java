package swordToOffer;


import java.util.ArrayList;
import java.util.List;

// 用栈实现队列
public class q_9 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.appendTail(1);
        q.appendTail(2);
        System.out.println(q.deleteHead());
        q.deleteHead();
        q.deleteHead();
    }
}

// 链表实现栈
// TODO 对 list添加
// TODO 对其增加并发控制
class Stack {
    private static List<Integer> l = new ArrayList();

    public int pop() {
        if (l.size() > 0)
            throw new  IllegalArgumentException("无更多数据！");
        int result = l.get(l.size() - 1);
        l.remove(l.size() - 1);
        return result;
    }

    public void push(int value) {
        l.add(value);
    }
}

// 两个栈实现队列
class Queue {
    private static Stack sTail = new Stack();
    private static Stack sHead = new Stack();

    public void appendTail(int value) {
        sTail.push(value);
    }

    public int deleteHead() {
        sHead.push(sTail.pop());
        return sHead.pop();
    }

}
