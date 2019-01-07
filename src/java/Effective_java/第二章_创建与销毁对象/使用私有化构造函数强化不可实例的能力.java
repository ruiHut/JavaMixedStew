package Effective_java.第二章_创建与销毁对象;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-07 22:43
 **/

public class 使用私有化构造函数强化不可实例的能力 {
    public static void main(String[] args) {

    }
}

/**
 * 对于某些全为静态方法 ，静态属性的类
 * 我们对构造函数私有化强化 以告知这是一个不需要实例的对象
 */
class Utils {

    private Utils(){
        throw new AssertionError();
    }

    private static int inInterger(int var){
        return var++;
    }

    private static int deInterger(int var){
        return var--;
    }
}