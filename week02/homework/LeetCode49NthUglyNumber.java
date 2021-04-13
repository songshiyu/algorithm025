//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//  示例:
//  输入: n = 10
//  输出: 12
//  解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//  说明:  
//  1 是丑数。
//  n 不超过1690。

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author songshiyu 剑指 Offer 49. 丑数
 * @create: 2021/4/12 09:12:00
 **/
public class LeetCode49NthUglyNumber {

    /**
     * 利用小根堆解题
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        seen.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    //TODO 还可以使用动态规划来做

    public static void main(String[] args) {
        int n = 12;
        nthUglyNumber(12);
    }

}
