//给定不同面额的硬币 coins 和一个总金额 amount。
// 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
// 你可以认为每种硬币的数量是无限的。
//
//        示例 1：
//        输入：coins = [1, 2, 5], amount = 11
//        输出：3
//        解释：11 = 5 + 5 + 1
//
//        示例 2：
//        输入：coins = [2], amount = 3
//        输出：-1
//
//        示例 3：
//        输入：coins = [1], amount = 0
//        输出：0
//
//        示例 4：
//        输入：coins = [1], amount = 1
//        输出：1
//
//        示例 5：
//        输入：coins = [1], amount = 2
//        输出：2
//
//        提示：
//        1 <= coins.length <= 12
//        1 <= coins[i] <= 231 - 1
//        0 <= amount <= 104

/**
 * @description:
 * @create: 2021/5/11 10:17:40
 **/
public class LeetCode322_07 {

    /**
     * 直接递归 由于存在大量重复计算，会超时
     *
     * @param coins
     * @param amount
     * @return
     */
    private int minCoins = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        solve(coins, amount, 0);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private void solve(int[] coins, int amount, int count) {

        if (amount == 0) {
            minCoins = Math.min(count, minCoins);
        }

        if (amount < 0) {
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            solve(coins, amount - coins[i], count + 1);
        }
    }

    /**
     * 递归+ 记忆化搜索
     *
     * @param coins
     * @param amount
     * @return
     */
    private int[] memory;

    public int coinChange2(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        memory = new int[amount + 1];
        memory[0] = 0;
        return solve2(coins, amount);
    }

    private int solve2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memory[amount] != 0) {
            return memory[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = solve2(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memory[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return memory[amount];
    }

    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
                dp[i] = min;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
