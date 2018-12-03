package jdk1_8新特性.Lambda表达式;

import java.util.Arrays;
import java.util.List;

/**
 * @program: Java-
 * @description: lambda_遍历容器类
 * @author: Mr.Zhou
 * @create: 2018-12-03 16:11
 **/

public class Lambda表达式实例_遍历容器类 {
    public static void main(String[] args) {
        List<String> lists = Arrays.asList("hello" , "world", "!");
        /**
         * 无Lambda的方式
         */
        for (String list: lists) {
            System.out.println(list);
        }

        System.out.println("------- 分割线 -------");

        /**
         * Lambda 方式遍历
         */

        lists.forEach((list)->{System.out.println(list);});
    }
}
