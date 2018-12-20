package 并发;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-20 13:57
 **/

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Runnable 是执行工作的独立任务 ， 他是没有返回值的， 如果希望有返回值可以实现
 * Callable接口
 */
class TaskWithResult implements Callable<String> {
    private static int j = 1;
    private static final int n = j++;
    private int id;
    public TaskWithResult(int id ){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.print("#" + n  + ": " + i + "   " );
        }
        return "result of TaskWithResult "+ id;
    }
}

/**
 * Future :    Future表示一个可能还没有完成的异步任务的结果，
 * 针对这个结果可以添加Callback以便在任务执行成功或失败后作出相应的操作
 */
public class 从任务中产生返回值 {
    public static void main(String[] args) {
        ExecutorService exce = Executors.newCachedThreadPool();
        ArrayList<Future<String>>  results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exce.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results ){
            try {
//                if (fs.isDone()) // 查询这个线程是否完成
                    System.out.println(fs.get()); //get（）方法可以当任务结束后返回一个结果，如果调用时，工作还没有结束，则会阻塞线程，直到任务执行完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exce.shutdown();
            }
        }
    }
}
