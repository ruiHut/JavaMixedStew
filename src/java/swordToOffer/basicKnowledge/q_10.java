package swordToOffer.basicKnowledge;


// 斐波那契数列
public class q_10 {
    public static void main(String[] args) {
        q_10 c = new q_10();
        c.fibonacci(1);
        c.fibonacci(10);
        System.out.println(c.cFibonacci(2));
        System.out.println(c.fibonacci(10) == c.cFibonacci(10));
//        c.fibonacci(10000);
        System.out.println(c.frogJump(3));
    }

    // 递归实现 - 效率很低 产生很多重复操作, 当输入值很大时，速度非常慢
    public int fibonacci(int n) {
        if (n < 0)
            throw new RuntimeException("输入小于0，n= " + n);

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 自下而上的计算 先计算 f(0) f(1) 在计算 f(n) 时间复杂度 O(N)
    public int cFibonacci(int n) {
        if (n < 0)
            throw new RuntimeException("输入小于0，n= " + n);

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;


        int[] res = {0, 1};
        for (int i = 3; i <= n; i++) {
            int prevRes = res[0] + res[1];
            res[0] = res[1];
            res[1] = prevRes;
        }

        return res[0] + res[1];
    }

    // TODO 斐波那契数列更快的解法


    // 青蛙跳台阶，一次可跳 n~1 阶。f(n) = 2~n-1
    public int frogJump(int n) {
        if (n < 1)
            throw new RuntimeException("输入小于1，n=" + n);

        return (int) Math.pow(2, (n - 1));
    }

}
