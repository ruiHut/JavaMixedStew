package 枚举类型;

import java.util.EnumSet;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-19 15:13
 **/

enum AlarmPonints {
    STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3
}

/**
 * EnumSet : 抽象类 用来代替传统基于int的‘位标志’
 * EnumSet 中的元素必须来自一个enum 上面的enum表示在一座大厦中， 警报传感器所在的位置
 *
 */
public class 使用EnumSet代替标志 {
    public static void main(String[] args) {
        EnumSet<AlarmPonints> ponints =  EnumSet.noneOf(AlarmPonints.class); // Empty set
        ponints.add(AlarmPonints.OFFICE1);
        System.out.println(ponints);
        ponints = EnumSet.allOf(AlarmPonints.class);
        System.out.println(ponints);
    }
}
