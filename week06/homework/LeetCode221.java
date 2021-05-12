/**
 * @description:
 * @create: 2021/5/12 10:26:10
 **/
public class LeetCode221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxSide = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                maxSide = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }

            }
        }
        return maxSide * maxSide;
    }
}
