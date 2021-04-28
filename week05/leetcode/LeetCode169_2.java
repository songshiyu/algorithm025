//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//    示例 1：
//    输入：[3,2,3]
//    输出：3
//
//    示例 2：
//    输入：[2,2,1,1,1,2,2]
//    输出：2

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author songshiyu 多数元素
 * @create: 2021/4/27 10:05:20
 **/
public class LeetCode169_2 {

    /**
     * 利用hash表的暴力解法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int mid = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> result = map.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        }).collect(Collectors.toList());

        if (result.size() != 0 && result.get(0).getValue() > mid) {
            return result.get(0).getKey();
        }
        return 0;
    }

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
