package 并发;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-20 10:35
 **/

public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private final Vector sharedQueue; // 内存缓冲区 自动增长的对象数组
    private final int SIZE; // 缓冲区大小
    private static AtomicInteger count = new AtomicInteger(); // 总数，原子操作
    private static final int SLEEPTIME = 1000;
    public Producer(Vector sharedQueue, int SIZE) {
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }
    @Override
    public void run() {
        int data;
        Random r = new Random();
        System.out.println("start producer id = " + Thread.currentThread().getId());
        try {
            while (isRunning) {
                // 模拟延迟
                Thread.sleep(r.nextInt(SLEEPTIME));
                // 当队列满时阻塞等待
                while (sharedQueue.size() == SIZE) {
                    synchronized (sharedQueue) {
                        System.out.println("Queue is full, producer " + Thread.currentThread().getId()
                                                   + " is waiting, size：" + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }
                // 队列不满时持续创造新元素
                synchronized (sharedQueue) {
                    data = count.incrementAndGet(); // 构造任务数据
                    sharedQueue.add(data);
                    System.out.println("producer create data:" + data + ", size：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupted();
        }
    }
    public void stop() {
        isRunning = false;
    }
}