package 并发;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: java_
 * @description: 消费者
 * @author: Mr.Zhou
 * @create: 2019-01-20 10:45
 **/

public class Consumer implements Runnable {
    private final Vector sharedQueue; // 内存缓冲区
    private final int SIZE; // 缓冲区大小
    private static final int SLEEPTIME = 1000;
    public Consumer(Vector sharedQueue, int SIZE) {
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }
    @Override
    public void run() {
        Random r = new Random();
        System.out.println("start consumer id = " + Thread.currentThread().getId());
        try {
            while (true) {
                // 模拟延迟
                Thread.sleep(r.nextInt(SLEEPTIME));
                // 当队列空时阻塞等待
                while (sharedQueue.isEmpty()) {
                    synchronized (sharedQueue) {
                        System.out.println("Queue is empty, consumer " + Thread.currentThread().getId()
                                                   + " is waiting, size：" + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }
                // 队列不空时持续消费元素
                synchronized (sharedQueue) {
                    System.out.println("consumer consume data：" + sharedQueue.remove(0) + ", size：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String args[]) throws InterruptedException {
        // 1.构建内存缓冲区
        Vector sharedQueue = new Vector();
        int size = 4;
        // 2.建立线程池和线程
        ExecutorService service = Executors.newCachedThreadPool();
        Producer prodThread1 = new Producer(sharedQueue, size);
        Producer prodThread2 = new Producer(sharedQueue, size);
        Producer prodThread3 = new Producer(sharedQueue, size);
        Consumer consThread1 = new Consumer(sharedQueue, size);
        Consumer consThread2 = new Consumer(sharedQueue, size);
        Consumer consThread3 = new Consumer(sharedQueue, size);
        service.execute(prodThread1);
        service.execute(prodThread2);
        service.execute(prodThread3);
        service.execute(consThread1);
        service.execute(consThread2);
        service.execute(consThread3);
        // 3.睡一会儿然后尝试停止生产者
        Thread.sleep(10 * 1000); // 主线程休息10s 将生产者关闭
        prodThread1.stop();
        prodThread2.stop();
        prodThread3.stop();
        // 4.再睡一会儿关闭线程池
        Thread.sleep(3000);
        service.shutdown();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Producer prodThread4 = new Producer(sharedQueue, size);
//        executorService.submit(prodThread4);
//        executorService.execute(prodThread4);
    }
}