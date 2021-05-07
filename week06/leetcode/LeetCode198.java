//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
// 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
// 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下，一夜之内能够偷窃到的最高金额。
//
//        示例 1：
//        输入：[1,2,3,1]
//        输出：4
//        解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//             偷窃到的最高金额 = 1 + 3 = 4 。
//
//        示例 2：
//        输入：[2,7,9,3,1]
//        输出：12
//        解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//             偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
//        提示：
//        1 <= nums.length <= 100
//        0 <= nums[i] <= 400

/**
 * @description: 打家劫舍
 * @create: 2021/5/7 14:43:03
 **/
public class LeetCode198 {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }

    /**
     * 动态规划 - 在空间层面进行优化
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        int sum1 = nums[0];
        int sum2 = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int tmp = sum1;
            if (sum1 < sum2) {
                sum1 = sum2;
            }
            sum1 = Math.max(tmp + nums[i], sum2);
        }
        return sum1;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1};
        System.out.println(rob2(num));
    }
}
