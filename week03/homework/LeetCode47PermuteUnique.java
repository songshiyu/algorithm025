//定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,1,2]
//        输出：
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        示例 2：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author songshiyu 全排列 II
 * @date 2021/4/17 21:31
 **/
public class LeetCode47PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int[] visited = new int[nums.length];
        permuteUnique(result, nums, visited, new ArrayList<Integer>());
        return new ArrayList<>(result);
    }

    private void permuteUnique(Set<List<Integer>> result, int[] nums, int[] visited, List<Integer> element) {
        if (element.size() == nums.length) {
            result.add(new ArrayList<>(element));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            element.add(nums[i]);
            permuteUnique(result, nums, visited, element);
            visited[i] = 0;
            element.remove(element.size() - 1);
        }
    }

}
