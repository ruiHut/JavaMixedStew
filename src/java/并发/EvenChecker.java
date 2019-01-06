package 并发;

import 并发.impl.IntGeneratorImpl2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: java_
 * @description: 消费者
 * @author: Mr.Zhou
 * @create: 2019-01-06 19:16
 **/

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private  final  int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if (val % 2 == 0) {   // 为偶数（）
                System.out.println(val + " noot even!" + id);
                generator.cancel();  // 修改标志位
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exsc = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exsc.submit(new EvenChecker(gp, i));
        }
        exsc.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

    public static void main(String[] args) {
        EvenChecker.test(new IntGeneratorImpl2());
    }
}

