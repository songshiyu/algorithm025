import java.util.Arrays;

/**
 * @author songshiyu 不同路径
 * @create: 2021/4/28 09:06:18
 **/
public class LeetCode62 {

    /**
     * 动态规划 DP
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //首先定义dp数组
        int[][] dp = new int[m][n];
        //因为第一行和第一列属于边界条件，只能向右或者向下，因为到达他们的路径只能为1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 在空间上对DP进行优化
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }


}
