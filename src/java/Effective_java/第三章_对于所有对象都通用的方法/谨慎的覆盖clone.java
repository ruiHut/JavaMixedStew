package Effective_java.第三章_对于所有对象都通用的方法;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-08 10:29
 **/

public class 谨慎的覆盖clone {
    public static void main(String[] args) {
        CloneDome1 cloneDome1 = new CloneDome1();
//        Object cloneDome11  = (Object)cloneDome1.clone();
        try {
            Class aClass = Class.forName(cloneDome1.getClass().getName());
            CloneDome1 cloneDome11 = (CloneDome1) cloneDome1.clone();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

    }
}

}
class CloneDome1 implements Cloneable {
    private int id;
    private int classId;

    @Override
    protected CloneDome1 clone() { // 当类中具有其他可变对象时 就会变得毫无意义
        try {
            return (CloneDome1) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}