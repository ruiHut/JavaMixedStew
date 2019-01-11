package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-11 20:16
 **/

public class Java反射机制 {
    public static void main(String[] args) {

    }
}

/**
 * Class反射对象描述类语义结构，可以从Class对象中获取构造函数，成员变量，
 * 方法类等类元素的反射对象，并以编程的方式通过这些反射对象对目标类对象进行操作
 * <p>
 * 主要的反射类：
 * Constructor: 类的构造函数反射类 通过Class.getConstructors()方法获取类的所以构造函数反射对象数组
 * java1.5 可以获取拥有特定入参的构造函数的反射对象。最主要的方法是newInstance(Object[] initargs),
 * 通过该方法创建一个对象类的实例。
 * Method: 类方法的反射类，通过Class.getDeclaredMethods()方法可以获取类的所有反射类对象数组
 * Method[],最主要的方法是invoke(Object obj, Object[] args) 通过Method对象 调用某对象的具体方法
 * Field： 类的成员变量的反射类，通过Class.getDeclareFields()方法获取类的成员变量数组反射对象
 * 通过value方法为目标对象的成员变量设置值
 * <p>
 * 另外 也提供了Package java1.5提供了AbbitatedElement反射类
 * 总之，Java反射体系保证了可以通过程序化的方式访问目标类的所有元素，对于private,或者protected成员变量和方法，只要
 * JVM的安全机制允许就可以通过反射调用。
 */

class ConstructorTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ConstructorTest test = new ConstructorTest();
        Class aClass = test.getClass().forName(test.getClass().getName());

        try {
            Constructor con = aClass.getConstructor();
            try {
                ConstructorTest test1 = (ConstructorTest) con.newInstance();
                test1.sayHello();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public void sayHello() {
        System.out.println("hello world");
    }
}

class MethodTest {
    public static void main(String[] args) {
        MethodTest test = new MethodTest();
        Class aClass = test.getClass();
        Method method = null;
        try {
            method = aClass.getMethod("say");
            method.invoke(test);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void say() {
        System.out.println("say hello world");
    }
}

/**
 * 私有成员对象
 * 和受保护方法反射调用测试
 */
class PrivateCar {
    private String color;

    protected void drive() {
        System.out.println("car`s color is " + color);
    }
}

class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<PrivateCar> clazz = (Class<PrivateCar>) loader.loadClass("反射.PrivateCar");
        PrivateCar pcar = clazz.newInstance();
        Field field = clazz.getDeclaredField("color");

        field.setAccessible(true);
        field.set(pcar, "red");

        Method method = clazz.getDeclaredMethod("drive", (Class[]) null);
        method.setAccessible(true);
        method.invoke(pcar,(Object[]) null);
    }

}