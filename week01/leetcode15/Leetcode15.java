//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//        注意：答案中不可以包含重复的三元组。
//
//         
//
//        示例 1：
//
//        输入：nums = [-1,0,1,2,-1,-4]
//        输出：[[-1,-1,2],[-1,0,1]]
//        示例 2：
//
//        输入：nums = []
//        输出：[]
//        示例 3：
//
//        输入：nums = [0]
//        输出：[]
//         
//
//        提示：
//
//        0 <= nums.length <= 3000
//        -105 <= nums[i] <= 105


import java.util.*;

/**
 * @author songshiyu  三数之和
 * @create: 2021/3/31 09:18:30
 **/
public class Leetcode15 {

    /**
     * 暴力求解法：直接三层嵌套循环
     *
     * @param
     * @return
     */
//    public static List<List<Integer>> threeSum(int[] nums) {
//
//        Set<List<Integer>> result = new HashSet<>();
//
//        if (nums == null || nums.length <= 2) {
//            return new ArrayList<>(result);
//        }
//        //提前排序，保证数组内数据有序；若此处不进行排序，在想result中添加list时，需要对list进行排序
//        Arrays.sort(nums);
//        for (int x = 0; x < nums.length - 2; x++) {
//            for (int y = x + 1; y < nums.length - 1; y++) {
//                for (int z = y + 1; z < nums.length; z++) {
//                    if (nums[x] + nums[y] + nums[z] == 0) {
//                        result.add(Arrays.asList(nums[x], nums[y], nums[z]));
//                    }
//                }
//            }
//        }
//
//        return new ArrayList<>(result);
//    }

    /**
     * 解法2：双层循环 + hash表 a + b + c = 0 => a + b = -c ,可以转换为两数求和的问题
     *
     * @param
     * @return
     */
//    public static List<List<Integer>> threeSum(int[] nums) {
//
//        if (nums == null || nums.length <= 2) {
//            return Collections.emptyList();
//        }
//
//        Arrays.sort(nums);
//
//        Set<List<Integer>> result = new HashSet<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            int target = -nums[i];
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int j = i + 1; j < nums.length; j++) {
//                if (map.containsKey(target - nums[j])) {
//                    result.add(Arrays.asList(nums[i], nums[j], target - nums[j]));
//                }
//                map.put(nums[j], nums[j]);
//            }
//        }
//        return new ArrayList<>(result);
//    }

    /**
     * 双指针，两边夹逼法 还是不够好，需要优化
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        //1.首先对数组进行排序，使之变为有序的
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y) {
                int sum = -(nums[x] + nums[y]);
                if (nums[i] == sum) {
                    result.add(Arrays.asList(nums[i], nums[x], nums[y]));
                }
                if (sum <= nums[i]) {
                    y--;
                } else {
                    x++;
                }
            }
        }
        return new ArrayList<>(result);
    }

}
