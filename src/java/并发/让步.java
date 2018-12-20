package 并发;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-20 15:44
 **/

/**
 *  如果 知道已经完成了在run（） 方法的循环的一次迭代工作中所需的工作，
 *  就可以给线程调度机制一个暗示。你的工作已经完成的差不多了 ，可以让别的线程使用cpu了
 *  这时候就算通过调用 yield() 方法来做出的。
 *  不过这只是一个暗示 ， 没有任何机制保证它会被采纳
 */
public class 让步 {
    public static void main(String[] args) {

    }
}
