package 枚举类型;

/**
 * @program: java_
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-18 21:20
 **/

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * enum 是继承自java.lang.enum 类 所以不能再继承其他类了 但是可以实现多个接口
 */

enum test implements Readable{
    HELLO , WORLD
    ;

    @Override
    public int read(CharBuffer cb) throws IOException {
        return 0;
    }
}
public class 实现_而非继承 {
    public static void main(String[] args) {

    }
}
