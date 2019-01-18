package 并发;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-18 22:30
 **/

public class AttempLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = lock.tryLock();
        try{
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2 , TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
        try{
            System.out.println("tryLock(2 , TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttempLocking al = new AttempLocking();
        al.untimed();
        al.timed();
        new Thread(){
            { setDaemon(true);}
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }
}
