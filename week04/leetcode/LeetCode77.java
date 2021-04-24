//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//        示例:
//        输入: n = 4, k = 2
//        输出:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author songshiyu
 * @date 2021/4/19 22:20
 **/
public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || n < k) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        slove(n, k, new LinkedList<Integer>(), result, 1);
        return result;
    }

    private void slove(int n, int k, LinkedList<Integer> element, List<List<Integer>> result, int start) {
        if (element.size() == k) {
            result.add(new ArrayList<>(element));
            return;
        }
        for (int i = start; i <= n - (k - element.size()) + 1; i++) {
            element.add(i);
            slove(n, k, element, result, i + 1);
            element.removeLast();
        }
    }
}
