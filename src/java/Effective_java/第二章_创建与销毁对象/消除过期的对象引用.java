package Effective_java.第二章_创建与销毁对象;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-07 23:18
 **/

public class 消除过期的对象引用 {
    public static void main(String[] args) {

    }
}

/**
 * 简单的栈的实现产生的内存泄漏
 */
class stack {
    private Object[] objects;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public stack() {
        objects = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        objects[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = objects[--size];
        objects[size] = null;
        return result; // 所有 pop对象都不会释放引用 这是 数组自动保存下标引用原因
    }

    private void ensureCapacity() {
        if (size == DEFAULT_INITIAL_CAPACITY)
            objects = Arrays.copyOf(objects, 2 * size + 1);
    }
}