import java.util.HashMap;
import java.util.Map;

/**
 * @author songshiyu 两数之和
 * @date 2021/4/10 15:29
 **/
public class LeetCode1TwoSum {

    /**
     * 利用hash表解题
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
