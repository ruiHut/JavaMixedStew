package Effective_java.第五章_泛型;

import java.util.EmptyStackException;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-12 19:55
 **/

public class 优先考虑泛型 {
    public static void main(String[] args) {

    }
}

/**
 * 使用泛型实现简单的栈
 * @param <E>
 */
class Stack<E> {
    private E[] elements;
//    private Object[] elements; 第二种解决方法
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack(){
//        elements = new E(DEFAULT_INITIAL_CAPACITY); 报错  因为数组为具体的
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; //第一种解决办法 直接跳过泛型，但是不是类型安全的

    }

    public void push(E e){
        elements[size++] = e;
    }

    public E pop(){
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null;
        return result;
    }
}