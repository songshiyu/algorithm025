/**
 * @description: 插入排序：选剩余的元素，插入到前面有序列表中正确的位置
 * @create: 2021/6/1 09:36:48
 **/
public class InsertSort {

    public static void insertSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 6, 7, 2, 5};
        insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
