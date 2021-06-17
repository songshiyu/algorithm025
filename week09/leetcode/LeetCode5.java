/**
 * @description:
 * @create: 2021/6/9 09:54:59
 **/
public class LeetCode5 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length(), len = 1;
        int left = 0, right = 0;
        int maxStart = 0, maxLength = 0;

        for (int i = 0; i < length; i++) {
            left = i - 1;
            right = i + 1;

            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }

            while (right < length && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }

            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len += 2;
            }

            if (len > maxLength) {
                maxStart = left;
                maxLength = len;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLength + 1);
    }

    public static void main(String[] args) {
        String aba = longestPalindrome("aba");
        System.out.println(aba);
    }
}
