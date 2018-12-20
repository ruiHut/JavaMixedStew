package 并发;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-20 14:40
 **/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程的优先级 将该线程的重要性传递给了调度器。
 * 调度器倾向于让优先级高的线程先执行
 * 但是这并不意味着 会发生死锁
 * 优先级低只是会执行的频率较低
 * 在绝大多数时间都应该默认优先级允许，
 * 试图操作线程优先级通常是一个错误
 */

public class 优先级 implements Runnable {
    private int countDown = 5;
    private volatile double d; // 设为 volatile 确保不进行编译器优化
    private int priority;

    public 优先级(int priority) {
        this.priority = priority;
    }

    public String toString(){
        return Thread.currentThread() +  ":  " + countDown;
    }


    @Override
    public void run() {
        Thread.currentThread().setPriority( priority);
        while (true){
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 ==0){
                    Thread.yield();
                }
                System.out.println(this);
                if (--countDown == 0) return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new 优先级(Thread.MIN_PRIORITY));
        }
       exec.execute(new 优先级(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
