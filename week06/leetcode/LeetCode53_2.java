//给定一个整数数组nums,找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//        示例 1：
//        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//        输出：6
//        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//        示例 2：
//        输入：nums = [1]
//        输出：1
//
//        示例 3：
//        输入：nums = [0]
//        输出：0
//
//        示例 4：
//        输入：nums = [-1]
//        输出：-1
//
//        示例 5：
//        输入：nums = [-100000]
//        输出：-100000
//
//        提示：
//        1 <= nums.length <= 3 * 104
//        -105 <= nums[i] <= 105

/**
 * @author songshiyu 最大子序和
 * @create: 2021/5/6 14:57:00
 **/
public class LeetCode53_2 {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
