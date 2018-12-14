package 枚举类型;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-14 16:46
 **/

class Dome {
    Spiciness degree;

    public Dome(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }
}

public class 静态导入用于enum {
    public static void main(String[] args) {
        System.out.println(new Dome(Spiciness.HOT));
        System.out.println(new Dome(Spiciness.FLAMING));
        System.out.println(new Dome(Spiciness.NOT));
        /**
         * Burrito is HOT
         * Burrito is FLAMING
         * Burrito is NOT
         */
    }
}