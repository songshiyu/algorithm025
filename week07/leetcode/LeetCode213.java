import java.util.Arrays;

/**
 * @description:
 * @create: 2021/5/12 11:27:48
 **/
public class LeetCode213 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        //将闭合的数组拆分成两种情况
        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(sub_rob(nums1), sub_rob(nums2));
    }

    public int sub_rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        return dp[nums.length];
    }
}
