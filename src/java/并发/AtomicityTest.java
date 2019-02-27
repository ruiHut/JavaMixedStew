package 并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by ZhouWang
 * DateTime:2019/2/27 17:57
 * Description : 同步规则 ： 如果你正在写一个变量，他可能接下来将被另一个线程读取，或者正在读取一个上一次已经被另一个线程写过的变量，
 * 那么你必须使用同步，并且，读写线程都必须用 **相同** 的监视器锁同步
 */
public class AtomicityTest implements Runnable{
    private int i = 0;
    // getVlaue() 方法中 虽然 return i 是原子性，
    // 但是缺少同步的话会使其数值可以在不稳定的中间状态被读取
    public synchronized int getValue() {return i;}
    private synchronized void evenIncrement () { i++; i++; }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2!= 0) {
                System.out.println(val);
                System.exit(0);
            }
            System.out.println(val);
        }
    }
}
