package Effective_java.类和接口;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-10 19:23
 **/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 封装，即隐藏对象的属性和实现细节，仅对外公开接口，控制在程序中属性的读和修改的访问级别
 * 1. 尽可能的使每个类或成员不可访问
 * 2. 实现序列化接口可能会导致泄露
 * 3. 长度非零的数组总是可变的 类具有共有的final静态数组域，或者返回这种域的方法这是致命的错误
 *              解决方法 1. 使公有数组私有化，并增加一个不可变的共有列表
 *                       2. 使数组私有化，添加公共方法，返回该数组克隆
 **/
public class 使类的成员的可访问性最小化 {
    public static void main(String[] args) {

    }
}

class Solution1 {

//    public static final Integer[] value(){
//        return null;
//    }

    //首先私有化
    private static final Integer[] value(){
        return null;
    }

    // 方法一
    public static final List<Integer> value(Integer[] integers){
        return Collections.unmodifiableList(Arrays.asList(integers));
    }


    // 方法二 方便起见 就改了改方法名字
    public static final Integer[] values(Integer[] integers){
        return integers.clone();
    }



}

