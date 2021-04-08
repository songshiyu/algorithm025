//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
//        示例:
//
//        输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//        输出: [3,3,5,5,6,7]
//        解释:
//
//        滑动窗口的位置                最大值
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7  size = 8  5
//         
//
//        提示：
//
//        你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author songshiyu 滑动窗口的最大值
 * @create: 2021/4/8 10:11:20
 **/
public class Leetcode59_MaxSlidingWindow {

    /**
     * 暴力求解
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        List<int[]> list = new ArrayList<>();

        int start = 0, end = k;
        while (start < nums.length - k + 1) {
            list.add(Arrays.copyOfRange(nums, start++, end++));
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            int[] array = list.get(i);
            Arrays.sort(array);
            result[i] = array[array.length - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }
}
