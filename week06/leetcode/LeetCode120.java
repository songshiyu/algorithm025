//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//每一步只能移动到下一行中相邻的结点上。
//相邻的结点 在这里指的是下标与上一层结点下标相同或者等于上一层结点下标 + 1 的两个结点。
// 也就是说，如果正位于当前行的下标i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//        示例 1：
//        输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//        输出：11
//        解释：如下面简图所示：
//        2
//        3 4
//        6 5 7
//        4 1 8 3
//        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//        示例 2：
//        输入：triangle = [[-10]]
//        输出：-10
//
//        提示：
//        1 <= triangle.length <= 200
//        triangle[0].length == 1
//        triangle[i].length == triangle[i - 1].length + 1
//        -104 <= triangle[i][j] <= 104
import java.util.List;

/**
 * @author songshiyu 三角形最小路径和
 * @create: 2021/5/6 11:05:50
 **/
public class LeetCode120 {

    //DP方程：
    //f(i,j) = min(f[i + 1,j],f[i + 1,j + 1]) + num[i,j]

    /**
     * 递归解题:会超时
     *
     * @param triangle
     * @return
     */
    public int minimumTotalR(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        return solve(0, 0, triangle);
    }

    private int solve(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size()) {
            return 0;
        }
        int left = solve(i + 1, j, triangle);
        int right = solve(i + 1, j + 1, triangle);
        return Math.min(left, right) + triangle.get(i).get(j);
    }

    /**
     * 优化递归解法：添加缓存
     *
     * @param triangle
     * @return
     */
    public int minimumTotalR2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.size()];
        return solve2(0, 0, triangle, dp);
    }

    private int solve2(int i, int j, List<List<Integer>> triangle, int[][] dp) {

        if (i == triangle.size()) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        } else {
            int left = solve2(i + 1, j, triangle, dp);
            int right = solve2(i + 1, j + 1, triangle, dp);
            int min = Math.min(left, right) + triangle.get(i).get(j);
            dp[i][j] = min;
            return min;
        }
    }

    /**
     * 动态规划 DP解题
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
