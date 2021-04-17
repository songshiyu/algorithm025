//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//        示例:
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
import java.util.ArrayList;
import java.util.List;

/**
 * @author songshiyu
 * @date 2021/4/17 9:20
 **/
public class LeetCode46Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] vistied = new int[nums.length];
        permute(nums, result, new ArrayList<>(), vistied);
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> element, int[] visited) {
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
            permute(nums, result, element, visited);
            visited[i] = 0;
            element.remove(element.size() - 1);
        }
    }
}
