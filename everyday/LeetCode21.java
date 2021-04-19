//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

/**
 * @author songshiyu 移除元素
 * 思路：
 * 遍历数组，当遇到数组中当前元素 == 给定value值时，将数组当前元素与数组最后一个索引的元素交换位置，
 * 并将i--，length--，重新比较当前i位置上的元素是否等于给定value
 * @create: 2021/4/19 09:28:55
 **/
public class LeetCode21 {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                nums[i] = nums[length - 1];
                length--;
                i--;
            }
        }
        return length;
    }
}
