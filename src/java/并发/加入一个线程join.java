package 并发;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-06 18:40
 **/

public class 加入一个线程join {
    public static void main(String[] args) {

    }
}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. " + "isInterrupted():" + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        System.out.println(getName() + "join completed");
    }
}

class Joining {
    public static void main(String[] args) {
        Sleeper
                sleeper = new Sleeper("Sleepy", 1000),
                grumpy = new Sleeper("Grumpy", 1000);
        Joiner
                dopey = new Joiner("Dopey", sleeper),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}