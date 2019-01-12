package Effective_java.第四章_类和接口;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-11 21:32
 **/

public class 优先考虑静态成员类 {
    public static void main(String[] args) {

    }
}


/**
 * nested class 嵌套类：定义在另一个类的内部的内，嵌套类存在的目的
 *          应该只是为他的外围类（enclosing class） 提供服务。
 *     嵌套类有四种：
 *          静态成员类 。 非静态成员类， 匿名类 ， 局部类
 *          除啦第一种其他三种都成为内部类
 *      静态成员类 ： 是一种最简单的嵌套类。最好把它看成普通的类，只是碰巧声明在另一个类的内部而已
 *              常见用法：作为公有的辅助类，仅当他的外部类一起使用时才有意义。
 *      方法之外使用
 *          非静态成员类： 成员类的每一个实例都需要一个指向其外围实例的引用
 *          静态成员类 ： 不需要外围类实例
 *      方法的内部使用
 *          匿名：只需要一个地方使用，且已经可以说明这个类的特征
 *          局部： 与匿名先否
 **/

class MySet<E> extends AbstractSet<E> {

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    // 每次都为一个新的实例 采用非静态成员类
    private  class MyIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

    @Override
    public int size() {
        return 0;
    }
}