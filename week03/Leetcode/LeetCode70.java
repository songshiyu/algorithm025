import java.util.HashMap;
import java.util.Map;

/**
 * @author songshiyu 爬楼梯
 * @date 2021/4/12 22:33
 **/
public class LeetCode70 {

    /**
     * f(n) = f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * 尾递归 - 相当于将上一步结果保存下来
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        return climbStairs2(n, 1, 1);
    }

    public int climbStairs2(int n, int a, int b) {
        if (n <= 1) {
            return b;
        }
        return climbStairs2(n - 1, b, a + b);
    }

}
