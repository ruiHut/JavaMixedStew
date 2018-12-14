package 枚举类型;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-14 18:02
 **/

enum Signal{
    YELLOW , RED, BLUE, WHITE
}
public class Switch语句中的enum {
    public static void main(String[] args) {


    }
    public void change() {
        Signal signal = Signal.YELLOW;
        switch (signal) { // 枚举有机结合了switch 语句 实质再判断其在数组中的索引位置
            case RED:
                System.out.println("is red"); break;
            case BLUE:
                System.out.println("is blue");break;
            case WHITE:
                System.out.println("is white");break;
            case YELLOW:
                System.out.println("is yellow");break;
             default:
                 System.out.println("is error");
        }
    }
}
