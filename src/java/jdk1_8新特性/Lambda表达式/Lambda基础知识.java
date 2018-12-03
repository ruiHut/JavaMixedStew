package jdk1_8新特性.Lambda表达式;

import org.junit.Test;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-03 18:11
 **/

public class Lambda基础知识 {
    @Test
    public static void main(String[] args) {
        Lambda基础知识 l = new Lambda基础知识();
        l.run1.run();
        l.run2.run();
    }

    // Runnable 一个接口且仅有一个abstract方法run（）待实现

    /**
     * 直接的匿名方法的实现
     */
    //(int x , int y)->{return x+y}

    /**
     * 省略方式 方法类型等 由编译器自动识别
     */
    //(x ,y)->x + y;

    /**
     * 1.8之前
     */

    Runnable run1 = new Runnable() {
        @Override
        public void run() {
            System.out.println("run1-----");
        }
    };

    /**
     * lamdbl 表达式
     */

    Runnable run2 = () -> System.out.println("run2-----"); //当仅有一条语句时可以省略 {} 类似 if（） ， for（）
}

