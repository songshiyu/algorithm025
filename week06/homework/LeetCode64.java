/**
 * @description: 最小路径和
 * @create: 2021/5/10 08:06:35
 **/
public class LeetCode64 {

    /**
     * dp方程：
     * when i == 0 then dp[i][j] = dp[i][j-1] + grid[i][j]
     * when j == 0 then dp[i][j] = dp[i-1][j] + grid[i][j]
     * dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        //dp[i][j] = dp[i-1][j] + dp[i][j-1]
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
