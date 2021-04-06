//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//        示例:
//
//        输入: [0,1,0,3,12]
//        输出: [1,3,12,0,0]
//        说明:
//
//        必须在原数组上操作，不能拷贝额外的数组。
//        尽量减少操作次数

/**
 * @author songshiyu
 * @date 2021/3/30 19:43
 **/


public class Leetcode283 {

    /**
     * 题解1：使用快速排序的思想来解决，选定0作为中间点，不等于0的元素放在右边，等于0的元素在右边
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    /**
     * 题解2：第一层for循环，使指针j来标识最后一个非零元素 2.第二层for循环，将索引j之后的元素置为0
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {

        if (nums == null) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
