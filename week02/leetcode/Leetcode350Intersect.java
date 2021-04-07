//给定两个数组，编写一个函数来计算它们的交集。
//        示例 1：
//        输入：nums1 = [1,2,2,1], nums2 = [2,2]
//        输出：[2,2]
//
//        示例 2:
//        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        输出：[4,9]
//
//        说明：
//        输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
//        我们可以不考虑输出结果的顺序。


import java.util.*;

/**
 * @author songshiyu  给定两个数组，编写一个函数来计算它们的交集。
 * @create: 2021/4/7 09:28:34
 **/
public class Leetcode350Intersect {

    /**
     * 进行三次循环 -- hash表
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            Integer value = map.getOrDefault(nums2[i], 0);
            if (value != 0) {
                list.add(nums2[i]);
                map.put(nums2[i], value - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    /**
     * 排序 + 双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length, length2 = nums2.length;
        int[] capacityArray = new int[length1 < length2 ? length1 : length2];
        int index1 = 0, index2 = 0, index = 0;

        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                capacityArray[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(capacityArray, 0, index);
    }

    /**
     * 归并排序的思想，原地进行排序
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0, index2 = 0, index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {

            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                nums1[index++] = nums1[index1++];
                index2++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }
}
