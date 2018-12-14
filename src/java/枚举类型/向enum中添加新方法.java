package 枚举类型;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-14 17:01
 **/

/**
 * 除了不能继承自一个enum之外 ， 我们基本上可以将enum 看作一个常规的类
 */
enum Feeling {
    HAPPER("is happy"), SAD("is sad"), SOSO("is soso"), WELL("is well"), GREAT("is great");

    /**
     * 每个枚举示例返回对自身的描述， 而不仅仅通过默认toString()实现 方法
     */
    private String des;

    private Feeling(String des) {
        this.des = des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }
}

public class 向enum中添加新方法 {
    public static void main(String[] args) {
        for (Feeling feel : Feeling.values()) {
            System.out.println("The " + feel.toString() + "is mean = " + feel.getDes());
        }
        /**
         * Before
         * The HAPPERis mean = is happy
         * The SADis mean = is sad
         * The SOSOis mean = is soso
         * The WELLis mean = is well
         * The GREATis mean = is great
         */

        for (Feeling feel : Feeling.values()) {
            feel.setDes("hello world");
        }

        for (Feeling feel : Feeling.values()) {
            System.out.println("The " + feel.toString() + "is mean = " + feel.getDes());
        }
        /**
         * after
         * The HAPPERis mean = hello world
         * The SADis mean = hello world
         * The SOSOis mean = hello world
         * The WELLis mean = hello world
         * The GREATis mean = hello world
         */

    }
}

/**
 * 覆盖toString() 方法 按照我们希望的格式显示
 */
class 覆盖enum的方法 {
    public static void main(String[] args) {
        for (Food food :
                Food.values()) {
            System.out.println(food);
        }
        /** result:
         *  Beef
         *  Egg
         */
    }
}

enum Food {
    BEEF, EGG;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }
}