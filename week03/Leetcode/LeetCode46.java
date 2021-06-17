import java.util.*;

/**
 * @description: 全排列
 * @create: 2021/6/4 16:39:16
 **/
public class LeetCode46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        permute(nums, result, new ArrayList<Integer>(), used);
        return result;
    }

    private static void permute(int[] nums, List<List<Integer>> result, ArrayList<Integer> element, boolean[] used) {
        if (element.size() == nums.length) {
            result.add(new ArrayList<>(element));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                element.add(nums[i]);
                permute(nums, result, element, used);
                element.remove(element.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
