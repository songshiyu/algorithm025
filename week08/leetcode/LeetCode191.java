/**
 * @description:
 * @create: 2021/5/20 09:44:07
 **/
public class LeetCode191 {

    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                result += 1;
            }
        }
        return result;
    }

}
