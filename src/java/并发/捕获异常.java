package 并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-06 19:07
 **/

public class 捕获异常 {
    public static void main(String[] args) {
        try {
            ExecutorService sxsc = Executors.newCachedThreadPool();
            sxsc.execute(new ExceptionThread());
        } catch (Exception e){
            System.out.println(e.getMessage()); // 没有捕获到异常
        }
    }
}

class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException("is exception");
    }
}