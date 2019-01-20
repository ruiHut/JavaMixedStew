package 并发;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: java_
 * @description: 消费者代码
 * @author: Mr.Zhou
 * @create: 2019-01-20 11:01
 **/

public class ConsumerByBQueue implements Runnable{
    private BlockingQueue<Integer> queue; // 内存缓冲区
    private static final int SLEEPTIME = 1000;
    private static volatile boolean isStop = true;
    public ConsumerByBQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        int data;
        Random r = new Random();
        System.out.println("start consumer id = " + Thread.currentThread().getId());
        try {
            while (isStop) {
                // 模拟延迟
                Thread.sleep(r.nextInt(SLEEPTIME));
                // 从阻塞队列中获取数据
                if (!queue.isEmpty()) {
                    data = queue.take();
                    System.out.println("consumer " + Thread.currentThread().getId() + " consume data：" + data
                                               + ", size：" + queue.size());
                } else {
                    System.out.println("Queue is empty, consumer " + Thread.currentThread().getId()
                                               + " is waiting, size：" + queue.size());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isStop = false;
    }
    public static void main(String args[]) throws InterruptedException {
        // 1.构建内存缓冲区
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();
        // 2.建立线程池和线程
        ExecutorService service = Executors.newCachedThreadPool();
        ProducerByBQueue prodThread1 = new ProducerByBQueue(queue);
        ProducerByBQueue prodThread2 = new ProducerByBQueue(queue);
        ProducerByBQueue prodThread3 = new ProducerByBQueue(queue);
        ConsumerByBQueue consThread1 = new ConsumerByBQueue(queue);
        ConsumerByBQueue consThread2 = new ConsumerByBQueue(queue);
        ConsumerByBQueue consThread3 = new ConsumerByBQueue(queue);
        service.execute(prodThread1);
        service.execute(prodThread2);
        service.execute(prodThread3);
        service.execute(consThread1);
        service.execute(consThread2);
        service.execute(consThread3);
        // 3.睡一会儿然后尝试停止生产者
        Thread.sleep(10 * 1000);
        prodThread1.stop();
        prodThread2.stop();
        prodThread3.stop();
        // 4.再睡一会儿关闭线程池
        Thread.sleep(3000);
        consThread1.stop();
        consThread2.stop();
        consThread3.stop();
        Thread.sleep(3000);
        service.shutdown();
    }
}