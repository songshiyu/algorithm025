import java.util.Arrays;

/**
 * @description: 归并排序
 * @create: 2021/6/2 09:30:33
 **/
public class MergeSort {

    public void mergeSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int[] tmp = Arrays.copyOfRange(nums, 0, nums.length);
        sort(nums, 0, nums.length - 1, tmp);
    }

    private void sort(int[] nums, int l, int r, int[] tmp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l, mid, tmp);
        sort(nums, mid + 1, r, tmp);
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, l, mid, r, tmp);
        }
    }

    private void merge(int[] nums, int l, int mid, int r, int[] tmp) {
        tmp = Arrays.copyOfRange(nums, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = tmp[j - l];
                j++;
            } else if (j > r) {
                nums[k] = tmp[i - l];
                i++;
            } else if (tmp[i - l] <= tmp[j - l]) {
                nums[k] = tmp[i - l];
                i++;
            } else {
                nums[k] = tmp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 6, 9, 3, 2, 8, 5, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
