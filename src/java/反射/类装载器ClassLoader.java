package 反射;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-11 19:45
 **/

public class 类装载器ClassLoader {
    public static void main(String[] args) {

    }
}

/**
 * ClassLoader
 * 类装载器就是寻找类的字节码文件并构造出类在JVM内部表示对象的组件。
 * 在java中，类装载器把一个类装入JVM中，需要经过以下步骤：
 * 1. 装载：查找和导入Class文件
 * 2. 链接： 执行校验，准备，和解析步骤，其中解析步骤是可以选择的。
 * （1）. 校验： 检查载入Class文件数据的正确性。
 * （2）. 准备： 给类的静态变量分配存储空间。
 * （3）. 解析： 将符号引用转换成直接引用。
 * 3. 初始化： 对类的静态变量，静态代码块执行初始化工作。
 */


class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader(); // currentThread : 当前线程
        System.out.println("current loader:"  + loader);
        System.out.println("parent loader:" + loader.getParent());
        System.out.println("grandparent loader:" + loader.getParent().getParent());
        try {
//            Class aClass = loader.loadClass("name"); // 获取指定类装载器需要装载类的名字。
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClassLoaderTest test = new ClassLoaderTest();
        ClassLoader loader2 = test.getClass().getClassLoader();
        Class aClass = loader2.getClass();
        System.out.println(loader2);
    }
}