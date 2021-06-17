package quickSort;

import java.util.Random;

/**
 * @description:
 * @create: 2021/6/3 09:36:39
 **/
public class QuickSort {

    public void quickSort(int[] nums) {
        if (nums == null) {
            return;
        }
        Random random = new Random();
        sort(nums, 0, nums.length - 1, random);
    }

    private void sort(int[] nums, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r, random);
        sort(nums, l, p - 1, random);
        sort(nums, p + 1, r, random);
    }

    private int partition(int[] nums, int l, int r, Random random) {
        int p = random.nextInt(r - l + 1) + l;
        swap(nums, p, l);

        int j = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] < nums[l]) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 7, 9, 2, 4, 6, 8};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
