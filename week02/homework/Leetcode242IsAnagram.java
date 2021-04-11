import java.util.Arrays;

/**
 * @author songshiyu 求两个字符串是否为字母异位词
 * @date 2021/4/10 15:12
 **/
public class Leetcode242IsAnagram {

    /**
     * 利用数组进行解题
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        //1.线判断两个字符串长度是否相等
        if (s.length() != t.length()) {
            return false;
        }
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        //比较排序之后的两个数组是否相等，若相等则证明两个字符串为字母异味词
        return Arrays.equals(sCharArray, tCharArray);
    }

    /**
     * 使用hash表解题
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if (arr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
