package 并发;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-20 15:50
 **/

class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        while (true){ // 后台线程dome 当程序启动后便一值在运行中。
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
                e.printStackTrace();
            }
        }
    }
}



/**
 * 所谓的后台线程， 指的就是程序运行的时候在后台提供的一种通用服务的线程
 * 并且这种线程并不属于程序中不可或缺的一部分。
 */
public class 后台线程 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            /*
            此例中 显式的创建了线程 ，以便设置它们的后台标志。
            通过编写 ThreadFactory 可以定制由Executor 创建的线程属性（后台 ， 优先级 ， 名称）
             */
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // 设置为后台线程 deamon 且必须在调用前设置
            daemon.start();
        }
        System.out.println("ALL deamons started");
        TimeUnit.MILLISECONDS.sleep(10000); // 增加休眠时间 可以看到 后台线程运行过程
        // 当main 线程结束后 所有线程也就相应全部结束 包括后台线程

    }
}

/**
 *  ThreadFactory 形式
 *   此例将后台状态全部设为true.
 */
class DomeThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}