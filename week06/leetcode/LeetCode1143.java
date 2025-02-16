//给定两个字符串text1和text2，返回这两个字符串的最长公共子序列的长度。如果不存在公共子序列，返回 0 。
//  一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//  例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//  两个字符串的公共子序列是这两个字符串所共同拥有的子序列。
//
//        示例 1：
//        输入：text1 = "abcde", text2 = "ace"
//        输出：3
//        解释：最长公共子序列是 "ace" ，它的长度为 3 。
//
//        示例 2：
//        输入：text1 = "abc", text2 = "abc"
//        输出：3
//        解释：最长公共子序列是 "abc" ，它的长度为 3 。
//
//        示例 3：
//        输入：text1 = "abc", text2 = "def"
//        输出：0
//        解释：两个字符串没有公共子序列，返回 0 。
//
//        提示：
//        1 <= text1.length, text2.length <= 1000
//        text1 和 text2 仅由小写英文字符组成。

/**
 * @description: 最长公共子序列
 * @create: 2021/5/7 10:11:56
 **/
public class LeetCode1143 {

    public static int longestCommonSubsequence(String text1, String text2) {

        /**
         * DP方程:
         *      text1[i-1] == text2[j-1] 时：dp[i][j] = dp[i - 1][j - 1] + 1
         *      text1[i-1] ！= text2[j-1] 时：dp[i][j] = max(dp[i-1][j],dp[i][j-1])
         */
        int text1Length = text1.length();
        int text2Length = text2.length();
        int[][] dp = new int[text1Length + 1][text2Length + 1];

        for (int i = 1; i <= text1Length; i++) {
            for (int j = 1; j <= text2Length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1Length][text2Length];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
