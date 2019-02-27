package 并发;

/**
 * Create by ZhouWang
 * DateTime:2019/2/27 22:58
 * Description :  for test 原子性和易变性
 * 对基本类型的读取和复制操作被认为是安全的原子性操作。但是对象处于不稳定状态时
 * ，仍然很有可能使用原子性操作来访问他们
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    //  添加synchronized 关键字确保在对象处于不稳定状态时，仍然以原子性操作出现
    public  static int nextSerialNumber() {
        return serialNumber++;
    }
}
