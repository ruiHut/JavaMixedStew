package 并发;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-06 18:22
 **/

public class 基础Thread {
    public static void main(String[] args) {
        Dome dome = new Dome();
        dome.start();
    }
}

class Dome extends Thread{

    @Override
    public void run() {
        while (true){
            System.out.println("hello world !");
            try {
                Dome.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
