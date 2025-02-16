//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
//
//        示例:
//        输入: 38
//        输出: 2
//        解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。

//        进阶:
//        你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？


/**
 * @author songshiyu
 * @date 2021/4/11 10:26
 **/
public class LeetCode258 {

    /**
     * 循环
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        int sum = Integer.MAX_VALUE;
        while (sum >= 10) {
            sum = digits(num);
            num = sum;
        }
        return sum;
    }

    public int digits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }


    /**
     * O(1)
     * @param num
     * @return
     */
    public int addDigits2(int num) {
        return (num -1 ) % 9 + 1;
    }

}
