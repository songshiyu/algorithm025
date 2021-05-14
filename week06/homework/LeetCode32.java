/**
 * @description: 最长有效括号
 * @create: 2021/5/13 08:33:37
 **/
public class LeetCode32 {

    /**
     * 动态规划：
     * 主要去理解 dp[i - dp[i - 1] - 2] 这块
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int size = s.length();
        int[] dp = new int[size];
        int maxLength = 0;

        for (int i = 1; i < size; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + dp[i];
                    }
                } else if (dp[i - 1] > 0) {
                    if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if ((i - dp[i - 1] - 2) >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
