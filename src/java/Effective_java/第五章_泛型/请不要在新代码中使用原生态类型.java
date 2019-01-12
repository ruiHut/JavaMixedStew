package Effective_java.第五章_泛型;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-12 18:52
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 泛型；声明中具有一个或者多个类型参数的类或者接口，就是泛型类或者泛型接口
 *      使用原生态类型会在运行时导致异常，因此不要再新代码中使用，原生太类型只是
 *      为了与引入泛型之前的遗留代码进行兼容和互用而提供的。
 *
 *          1. Set<Object>是个参数化类型，表示可以包含任何对象类型的一个集合；
 *          2. Set<?>是一个通配类型，表示只能包含某种未知对象类型的一个集合；
 *          3. Set则是一个原生态类型
 *
 *          总结 ： 前两种是安全的，最后一个不安全
 *
 */

class 参数化类型 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("hello, world!");
//        set.add(1); 编译器报错
    }
}

class 通配类型 {
    public static void main(String[] args) {
        Set<?> set = new TreeSet<>();
//        set.add("hello, world!");
//        set.add(1); 编译器报错
        List<?> es =new ArrayList<>();
        if (set instanceof Object) {
            Object o = (Object) set;
        }
    }
    public void Say(Set<?> e){

    }
}


public class 请不要在新代码中使用原生态类型 {
    public static void main(String[] args) {

    }
}
