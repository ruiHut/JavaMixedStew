package 并发;

/**
 * Create by ZhouWang
 * DateTime:2019/2/28 9:42
 * Description :   同步控制块 实例
 */
class Pair {
    private int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // 默认初始值为 0，0
    public Pair() {
        this(0, 0 );
    }
    public int getX() { return x;}
    public int getY() { return y;}
    public void incrementX() { x++; }
    public void incrementY() { y++; }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class CriticalSection {
}
