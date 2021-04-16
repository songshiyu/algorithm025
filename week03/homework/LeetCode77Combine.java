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
 * @create: 2021/4/16 09:06:52
 **/
public class LeetCode77Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || n < k) {
            return result;
        }
        LinkedList<Integer> element = new LinkedList<>();
        recoursion(n, k, 1, result, element);
        return result;
    }

    /**
     * @param n
     * @param k
     * @param start   每次递归的开始位置
     * @param result
     * @param element
     */
    private void recoursion(int n, int k, int start, List<List<Integer>> result, LinkedList<Integer> element) {
        if (element.size() == k) {
            //此处需注意，要新创建一个ArrayList将element放进去，否则在执行removeLast后，element会被清空
            result.add(new ArrayList<>(element));
            return;
        }
        for (int i = start; i <= n; i++) {
            element.add(i);
            recoursion(n, k, i + 1, result, element);
            //此处需要将element列表还原到上一步
            element.removeLast();
        }
    }

    /**
     * 对递归内，循环终止条件的优化
     *
     * @param n
     * @param k
     * @param start   每次递归的开始位置
     * @param result
     * @param element
     */
    private void recoursion2(int n, int k, int start, List<List<Integer>> result, LinkedList<Integer> element) {
        if (element.size() == k) {
            result.add(new ArrayList<>(element));
        }

        //此处n的范围，不需要去遍历整个n，只需要遍历到符合要求的位置即可
        for (int i = start; i <= n - (k - element.size()) + 1; i++) {
            element.add(i);
            recoursion2(n, k, i + 1, result, element);
            element.removeLast();
        }
    }
}
