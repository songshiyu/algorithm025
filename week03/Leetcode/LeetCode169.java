//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//        示例 1：
//        输入：[3,2,3]
//        输出：3

//        示例 2：
//        输入：[2,2,1,1,1,2,2]
//        输出：2

import java.util.Arrays;

/**
 * @author songshiyu 多数元素 TODO
 * @date 2021/4/17 21:43
 **/
public class LeetCode169 {

    /**
     * 排序解决
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }

    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int cand = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cand == nums[i]) {
                count++;
            } else {
                if (--count == 0) {
                    cand = nums[i];
                    count = 1;
                }
            }
        }
        return cand;
    }

}
