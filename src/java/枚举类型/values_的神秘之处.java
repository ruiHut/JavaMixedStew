package 枚举类型;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-15 10:17
 **/
enum Explore {
    HERE , THERE
}
public class values_的神秘之处 {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("---- analyze " + enumClass + "-----");
        System.out.println("interfaces :");
        for (Type type:
             enumClass.getGenericInterfaces()) {
            System.out.println(type);
        }
        System.out.println("base : " + enumClass.getSuperclass());
        System.out.println("methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m :
               enumClass.getMethods() ) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }
    public static void main(String[] args) {
        Set<String> exploremethods = analyze(Explore.class);
        Set<String> enummethods  = analyze(Enum.class); // enum 没有 values方法

    }
}

