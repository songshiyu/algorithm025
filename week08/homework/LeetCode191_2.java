/**
 * @description: 位1的个数
 * @create: 2021/5/21 09:31:28
 **/
public class LeetCode191_2 {

    /**
     * 位运算，将二进制数最后一位和1进行与运算后，再将二进制数右移一位
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
