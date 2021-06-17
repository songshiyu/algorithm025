package quickSort;

/**
 * @description:
 * @create: 2021/6/3 14:34:09
 **/
public class DoubleQuickSort {

    public void doubleQuickSort(int[] arr) {
        if (arr == null) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        //1 0 1 2
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, l, j);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2};
        DoubleQuickSort quickSort = new DoubleQuickSort();
        quickSort.doubleQuickSort(nums);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
