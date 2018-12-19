package 枚举类型;

import java.util.Random;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-19 13:11
 **/


class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
/**
 * 古怪的语法 ：<T extends Enum<T>> 表示enum实例
 * 而将 Class<T> 作为参数的话， 我们就可以利用Class对象得到enum实例的数组了
 * 重载后的random()方法 只需要使用T[]作为参数， 因为他并不会调用Enum 上的任何操作 ，他只需从数组中随机选择一个元素即可
 * 这样我们返回的正是enum类型。
 */
enum Test{
    HELLO , WORLD  ,WHAT , 
}
public class 随机选取 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(Test.class));
        }

    }
}
