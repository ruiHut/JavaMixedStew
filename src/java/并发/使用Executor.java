package 并发;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-19 19:11
 **/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java SE5 中的执行器Executor 将为你管理Thread对象， 简化并发编程 ，
 * 它在客户端和执行之间提供一个间接层。与客户端之间执行任务不同 ，
 * 这个中介对象将执行任务。它允许你管理异步任务的执行，而无需显示的管理线程的生命周期
 * Executor 是SE5/6 中启动任务的优选方法。
 */
public class 使用Executor {
    public static void main(String[] args) {
        /*
        非常常见的是，一个Executor被用来创建和管理系统中所有的任务
         */
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new 定义任务());
        }
        exec.shutdown(); // 防止新任务提交到Executor中 将继续完成调用之前的提交的所有任务
    }
}
