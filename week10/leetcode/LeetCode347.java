import java.util.*;

/**
 * @description: 前 K 个高频元素  桶排序
 * @create: 2021/6/1 16:17:53
 **/
public class LeetCode347 {

    /**
     * 使用hash表+优先队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length <= k) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else {
                if (map.get(key) > map.get(queue.peek())) {
                    queue.poll();
                    queue.add(key);
                }
            }
        }

        //取出堆中的最小元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove();
        }
        return res;
    }
}
