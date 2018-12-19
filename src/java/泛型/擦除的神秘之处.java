package 泛型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-19 13:25
 **/


class Forb{}

public class 擦除的神秘之处 {
    public static void main(String[] args) {
        List<Forb> list = new ArrayList<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters())); // [E]
        /**
         * 再泛型代码内部 ， 无法获取任何有关泛型参数类型的信息
         * java泛型是通过擦出来实现的。
         * 因此 在运行时都会当作他们的原生类型 即 list
         */
    }
}
