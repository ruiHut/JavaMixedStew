package HashMap;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: java_
 * @description: hashcode
 * @author: Mr.Zhou
 * @create: 2018-12-12 17:01
 **/

public class Dome1 {

    /**
     * 此实例提醒我们使用自定义类型作为 key值时 需要重写父类hashcode（） 和 equals（） 方法
     * detect : 察觉
     * @param type
     * @param <T>
     * @throws Exception
     */
    private static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();

        for (int i = 0; i < 10; i++)
            map.put(ghog.newInstance(i) , new Prediction());

        System.out.println("map = "+map);
        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looking up predction for" + gh);
        if (map.containsKey(gh))  // false Groundhog 默认继承父类Object 所以这里使用hashcode() 方法生成散列码 并且默认使用对象地址计算散射码 所以不同
            System.out.println(map.get(gh)); // 解决方案 重写 hashcode（） 和 equals（） 方法（HashMap 使用 equals() 判断当前的键是否与表中存在的键相同）
        else
            System.out.println("Key not found: " + gh);
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
}

/**
 * 以下dome作为演示 将对象作为键  Groundhog（土拨鼠）->key Prediction (天气预报)--> value
 */

/**
 * 土拨鼠
 */
class Groundhog{
    protected int number;

    public Groundhog(int number){
        this.number = number;
    }

    @Override
    public String toString(){
        return "Groundhog #" + number;
    }

    /**
     * 需要重写 hashcode（） 和equals（）方法
     */

    @Override
    public int hashCode() {
//        return super.hashCode();
        return number; // 将产生比较的hashcode 改为自定义属性 number
    }

    /**
     * 正确的equals() 方法必须满足下列五个条件
     * 1. 自反性。 对于任意x ， x.equals(x) 一定返回true
     * 2. 对称性。 对于任意x和y ，如果y.equals(x)返回true，则y.equals(x) 一定返回true
     * 3. 传递性。 对于任意x,y,z x == y y == z 那么 z一点等于x（简写一下）
     * 4. 一致性。 对于任意x，y 如果两个对象等价信息没有改 无论多少次equals 都不会改结果
     * 5. 对任何不是null的x ，  x.equals(null) 一定是false
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        return obj instanceof Groundhog
                       && (number == ((Groundhog) obj).number);
    }

}

/**
 * 天气预报
 */

class Prediction{
    private static Random random = new Random(47);
    private boolean shadow = random.nextDouble() > 0.5;

    @Override
    public String toString(){
        if (shadow)
            return "Six more weeks of Winter!";
        else
            return "Early Spring!";
    }
}