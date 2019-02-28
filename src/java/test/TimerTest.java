package test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Create by ZhouWang
 * DateTime:2019/2/28 9:25
 * Description :    测试java自带的Timer类
 *  Timer: 默认创建一个新的进程 且不会主动停止
 */
public class TimerTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("hello world");
                }
            }, 1000);
        }
        System.out.println(1);
    }
}
