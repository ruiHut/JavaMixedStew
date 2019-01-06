package 并发.impl;

import 并发.IntGenerator;

import java.util.Random;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-06 19:30
 **/

public class IntGeneratorImpl extends IntGenerator {
    @Override
    public int next() {
        Random random = new Random(47);
        return random.nextInt(100);
    }
}
