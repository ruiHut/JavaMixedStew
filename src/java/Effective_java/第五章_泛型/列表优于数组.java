package Effective_java.第五章_泛型;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-12 19:32
 **/

/**
 * 数组和泛型相比，有两个重要的不同点
 *      首先，数组是协变的（covariant）
 *              泛型是不可变的(invariant)
 *      其次， 数组是具体化的，数组只有在运行时才知道并检查它们的有元素约束
 *      泛型则是通过擦除。因此泛型只在编译时强化他们的类型信息，并在运行时丢弃
 *
 *  当数组和列表混合使用时，优先将数组改为列表使用
 **/

 public class 列表优于数组 {
    public static void main(String[] args) {

    }
}
