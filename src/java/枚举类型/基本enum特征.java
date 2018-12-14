package 枚举类型;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-14 16:21
 **/

public class 基本enum特征 {
    public static void main(String[] args) {
        System.out.println(Shrubbery.valueOf("GUOUND"));
        System.out.println(Shrubbery.values().toString());
        System.out.println(Shrubbery.CRAWLING); // 返回该字符串 区别于valueOf 如果没有 会报错
        for (Shrubbery s :
            Shrubbery.values()    ) {
            System.out.println(s.ordinal()); // 返回该声明字符的排序 默认从0开始 enum用一个数组包装
            System.out.println(s);
            System.out.println(" compareTo " + s.compareTo(Shrubbery.GUOUND)  ); // 返回两者在数组中索引的差值
                                    // 例  GUOUND.compareTo(Shrubbery.GUOUND) == 0
                                    //     CRAWLING.compareTo(Shrubbery.GUOUND) == 1
            System.out.println(s.getDeclaringClass());  // class 枚举类型.Shrubbery  两者结果相同
            System.out.println(s.getClass()); //           class 枚举类型.Shrubbery
            if (s == Shrubbery.CRAWLING)
                System.out.println("相同 ！");
        }
    }
}

/**
 * Shrubbery : 灌木林
 * GUOUND: 土地
 * HANGING:  悬挂
 * CRAWLING ：表面涂布不匀
 */
enum Shrubbery {
    GUOUND , CRAWLING ,HANGING;

    /**
     * 默认toString（） 返回字符串数值 // 遍历枚举
     */
//    @Override
//    public String toString() {
//        return "hello";
//    }
}
