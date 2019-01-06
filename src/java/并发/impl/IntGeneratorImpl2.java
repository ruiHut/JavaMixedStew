package 并发.impl;

import 并发.IntGenerator;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-06 19:32
 **/

public class IntGeneratorImpl2 extends IntGenerator {
    private volatile int  currentEventValue = 0; // 设为可见 没有效果 因为 ++x 非原子性操作
    @Override
    public  int next() { //synchronized 加锁 保证安全
        ++currentEventValue;  // 不安全 非原子性
        if (currentEventValue %2 != 0)
            return currentEventValue;
        return currentEventValue-1;
    }
}
