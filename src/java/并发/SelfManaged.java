package 并发;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-06 18:25
 **/

public class SelfManaged implements Runnable {
    private SelfManaged selfManaged;
    private Thread t = new Thread(this);

    public SelfManaged() throws InterruptedException {
        t.start();
        t.sleep(1000);
    }

    @Override
    public void run() {
        while (true)
            System.out.println("hello world !");
    }
}
class Test {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
