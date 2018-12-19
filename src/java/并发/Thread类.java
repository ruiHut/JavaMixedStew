package 并发;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-19 18:39
 **/

/**
 * 将Runnable 对象转变为工作任务的传统方式是把它提交给一个Thread 构造器
 */
public class Thread类 {
    public static void main(String[] args) {
         Thread t = new Thread(new 定义任务());
         t.start();
        System.out.println("Waiting for LiftOff");
        for (int i = 0; i < 100; i++) { // 当i的值增大时 可以看到两个线程交替工作的效果
            System.out.println("main线程");
            Thread.yield();
            /*
            Thread.yield() 的调用是对线程调度器 （java线程机制的一部分 ， 可以将cpu从一个线程转移到另一个线程）
            的一种建议 ， 他在生命： "我已经执行完声明周期中最重要的部分了，此刻正是切换给其他任务执行一3段时间的大好时机"。
            这完全是选择性的，但是这里使用它是因为他会在这些示例中产生根据有趣的输出。
             */
        }
        System.out.println(t.isAlive()); // 当对象的run()方法结束后  结果为：false
        /*
                控制台输出结果：
        Waiting for LiftOff
        #0(9).  #0(8).  #0(7).  #0(6).  #0(5).  #0(4).  #0(3).  #0(2).  #0(1).  #0(Liftoff!).
         */
    }
    /**
     * Thread构造器 只需要 一个Runable对象。 调用start() 方法为该线程执行必须的初始化操作 ， 然后调用run()方法
     * ，以便在这个新线程中启动该任务。
     * 此例中start() 方法的调用已经归属于另一个线程的操作了 因此main() 线程会继续执行接下来的命令
     * 任何线程都可以启动另一个线程 因此 程序会同时运行两个方法。
     * 这种线程任务不断交换是由线程调度器自动控制的。 如果在你的机器中有多个处理器，线程调度器将会在这些处理器之间默默的分发线程。
     * 这与jdk版本不同而产生差异 早期jdk不会频繁对时间片进行切换。
     * tips : 一个线程会创建一个单独的执行线程，在对start() 的调用完成之后 ， 他仍然会继续存在。
     */
}
