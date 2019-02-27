package 并发;

/**
 * Create by ZhouWang
 * DateTime:2019/2/27 22:58
 * Description :  for test 原子性和易变性
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
