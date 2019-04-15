package swordToOffer.basicKnowledge;


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

        QueueStack queueStack = new QueueStack();
        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(3);
        queueStack.pop();
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

    public int size() {
        return stack2.size() + stack1.size();
    }

    public boolean empty() {
        return size() == 0;
    }
}


// 两个队列实现栈
class QueueStack {
    private static Queue queue1 = new Queue();
    private static Queue queue2 = new Queue();
    // 代表当前存档队列是否为队列 1
    // TODO 不需要该字段，可由一个队列是否为空来判断
    private boolean isQueue1 = true;

    public void push(int value) {
        if (isQueue1)
            queue1.push(value);
        else
            queue2.push(value);
    }

    public int pop() {
        // 得到当前正使用队列
        Queue curQueue = queue2;
        Queue nextQueue = queue1;
        if (isQueue1) {
            curQueue = queue1;
            nextQueue = queue2;
        }

        if (curQueue.empty())
            throw new RuntimeException("Queue is empty");

        return exchangeQueue(curQueue, nextQueue);
    }

    private int exchangeQueue(Queue curQueue, Queue nextQueue) {
        for (int i = 0; i < curQueue.size(); i++) {
            // 当前队列最后一个元素，即需要弹出元素
            if (i == curQueue.size() - 1) {
                return curQueue.pop();
            }

            nextQueue.push(curQueue.pop());
        }
        return curQueue.pop();
    }
}

// 一个队列实现栈
class Mystack {
    private static Queue queue = new Queue();

    public void push(int value) {
        queue.push(value);
    }

    public int pop() {
        if (queue.empty())
            throw new RuntimeException("Stack is empty!");

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            // 将头元素插入回队尾元素，直至最后一个待弹出元素;
            queue.push(queue.pop());
        }

        return queue.pop();
    }
}