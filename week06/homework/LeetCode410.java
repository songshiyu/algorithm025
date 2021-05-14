import java.util.Arrays;

/**
 * @description: 分割数组的最大值
 * @create: 2021/5/14 10:51:00
 **/
public class LeetCode410 {

    public int splitArray(int[] nums, int m) {
        int length = nums.length;
        //求前缀和，preSum[i] = sum[0...1]
        int[] preSum = new int[length + 1];
        preSum[0] = 0;
        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        //区间[i..j]的和 preSum[j+1] - preSum[i]
        int[][] dp = new int[length][m + 1];
        //初始化dp数组
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        //分割数为1，及不分割的情况下，所有的前缀和就是依次的状态值
        for (int i = 0; i < length; i++) {
            dp[i][1] = preSum[i + 1];
        }

        //从分割数为2开始地推
        for (int k = 2; k <= m; k++) {
            //还未计算出的i是从j的最小值的下一位开始，因此是k-1
            for (int i = k - 1; i < length; i++) {
                //j表示第k-1个区间的最后一个元素的下标，最小值为k-2,最大值为length-2(最后一个区间至少有一个元素)
                for (int j = k - 2; j < i; j++) {
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k - 1], preSum[i + 1] - preSum[j + 1]));
                }
            }
        }
        return dp[length - 1][m];
    }

}
