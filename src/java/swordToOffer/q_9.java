package swordToOffer;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 用栈实现队列
public class q_9 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(1);
        q.push(2);
        System.out.println(q.pop());

        ListStack s = new ListStack();
        s.push(1);
        s.push(2);
        System.out.println(s.pop());
    }
}

// 链表实现栈
// TODO 对 list添加
// TODO 对其增加并发控制
class ListStack {
    private static List<Integer> l = new ArrayList();

    public int pop() {
        if (l.size() == 0)
            throw new RuntimeException("无更多数据！");

        return l.remove(l.size() - 1);
    }

    public void push(int value) {
        l.add(value);
    }

    public boolean empty() {
        return l.size() == 0;
    }
}

// 两个栈实现队列
class Queue {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    // 从队尾添加元素
    public void push(int value) {
        stack1.push(value);
    }

    // 从队列头部弹出元素
    public int pop() {
        if (stack1.empty() && stack2.empty())
            throw new RuntimeException("Queue is empty");

        if (stack2.empty()) {
            // 将 stack1 中保留数据，推到 stack2
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
