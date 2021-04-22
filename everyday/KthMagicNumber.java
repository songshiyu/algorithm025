//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
//注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
//        示例 1:
//        输入: k = 5
//        输出: 9

import java.util.*;

/**
 * @author songshiyu
 * @date 2021/4/20 22:51
 **/
public class KthMagicNumber {

    /**
     * 使用优先队列解题
     *
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        Set<Long> result = new HashSet<>();
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        while (true) {
            //优先队列中每次取出来的值都是最小值
            Long value = queue.poll();
            if (!result.contains(value)) {
                result.add(value);
                queue.add(value * 3);
                queue.add(value * 5);
                queue.add(value * 7);
                if (result.size() == k) {
                    return value.intValue();
                }
            }
        }
    }
}
