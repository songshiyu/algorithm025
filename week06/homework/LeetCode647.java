/**
 * @description: 最大回文数
 * @create: 2021/5/12 15:58:28
 **/
public class LeetCode647 {

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
