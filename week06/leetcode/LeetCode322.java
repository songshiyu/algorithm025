//给定不同面额的硬币coins和一个总金额amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//你可以认为每种硬币的数量是无限的。
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
 * @author songshiyu
 * @create: 2021/5/6 16:53:53
 **/
public class LeetCode322 {
    private int res = Integer.MAX_VALUE;

    /**
     * 直接递归:直接超出时间限制
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        //递归
        solve(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void solve(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            res = Math.min(res, count);
        }

        for (int i = 0; i < coins.length; i++) {
            solve(coins, amount - coins[i], count + 1);
        }
    }

    /**
     * 递归+缓存
     *
     * @param coins
     * @param amount
     * @return
     */
    private static int[] memory;

    public static int coinChange2(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }
        //构造一个容量为amount的数组，将每一步进行缓存
        memory = new int[amount];
        return solve2(coins, amount);
    }

    private static int solve2(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memory[amount - 1] != 0) {
            return memory[amount - 1];
        } else {
            //分布求出每一个amount的最小值
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int res = solve2(coins, amount - coins[i]);
                if (res >= 0 && res < min) {
                    min = res + 1;
                }
            }
            memory[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        }
        return memory[amount - 1];
    }

    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange3(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return -1;
        }

        memory = new int[amount + 1];
        memory[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && memory[i - coins[j]] < min) {
                    min = memory[i - coins[j]] + 1;
                }
            }
            memory[i] = min;
        }
        return memory[amount] == Integer.MAX_VALUE ? -1 : memory[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
        System.out.println(coinChange2(coins, amount));
    }
}
