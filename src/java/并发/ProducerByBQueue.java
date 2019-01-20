package 并发;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: java_
 * @description: BlockingQueue阻塞队列方式实现
 * @author: Mr.Zhou
 * @create: 2019-01-20 10:57
 **/

public class ProducerByBQueue implements Runnable{
    private volatile boolean isRunning = true;
    private BlockingQueue<Integer> queue; // 内存缓冲区
    private static AtomicInteger count = new AtomicInteger(); // 总数，原子操作
    private static final int SLEEPTIME = 1000;
    public ProducerByBQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
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
                // 往阻塞队列中添加数据
                data = count.incrementAndGet(); // 构造任务数据
                System.out.println("producer " + Thread.currentThread().getId() + " create data：" + data
                                           + ", size：" + queue.size());
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.err.println("failed to put data：" + data);
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
