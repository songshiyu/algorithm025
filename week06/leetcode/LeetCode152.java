//给你一个整数数组nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//        示例 1:
//        输入: [2,3,-2,4]
//        输出: 6
//        解释: 子数组 [2,3] 有最大乘积 6。
//
//        示例 2:
//        输入: [-2,0,-1]
//        输出: 0
//        解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
/**
 * @author songshiyu 乘积最大子数组
 * @create: 2021/5/6 15:32:23
 **/
public class LeetCode152 {

    /**
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //由于乘法自身特性，两个负数相乘为正数，因此需要记录下最大值和最小值
        int tmpMax = 1;
        int tmpMin = 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //当num[i]为负数时
            if (nums[i] < 0) {
                int tmp = tmpMax;
                tmpMax = tmpMin;
                tmpMin = tmp;
            }
            tmpMax = Math.max(tmpMax * nums[i], nums[i]);
            tmpMin = Math.min(tmpMin * nums[i], nums[i]);
            max = Math.max(tmpMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -1, -1};
        System.out.println(maxProduct(nums));
    }
}
