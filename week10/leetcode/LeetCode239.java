import java.util.LinkedList;

/**
 * @description: 滑动窗口最大值
 * @create: 2021/6/1 14:25:06
 **/
public class LeetCode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }
        //定义双向队列，保存窗口最大值的数组位置，保证队列中数组的位置的值从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();
        //定义结果数组
        int[] result = new int[nums.length - k + 1];
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            //判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            //当窗口长度为k时，保存当前窗口中的最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
