package 并发;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-19 16:50
 **/

/**
 * 线程可以驱动任务，因此你需要一种描述任务的方式，这可以由Runnable接口来提供。
 * 要定义任务，只需要实现run()方法，使得该任务可以执行你的命令。
 */

public class 定义任务 implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    /*
    标识符id 可以用来区分任务的多个实例 因为是final的所有一旦被初始化就不希望被修改。
     */
    private final int id = taskCount++;

    public 定义任务() {

    }

    public 定义任务(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                       (countDown > 0 ? countDown : "Liftoff!") + "). ";
    }

    /**
     * 任务的run（）方法 通常总会有某种形式的循环 使得任务一直运行下去直到不再需要。
     * 但是run()方法并无特殊之处--他不会产生任何内在的线程能力。要实现线程行为 ，
     * 你必须显示的将一个任务附着到线程上。
     */

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status()+ " ");
            /*
            Thread.yield() 的调用是对线程调度器 （java线程机制的一部分 ， 可以将cpu从一个线程转移到另一个线程）
            的一种建议 ， 他在生命： "我已经执行完声明周期中最重要的部分了，此刻正是切换给其他任务执行一3段时间的大好时机"。
            这完全是选择性的，但是这里使用它是因为他会在这些示例中产生根据有趣的输出。
             */
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        定义任务 launch = new 定义任务();
        launch.run();
    }
}
