/**
 * @description: 字符串中的第一个唯一字符
 * @create: 2021/5/31 11:22:38
 **/
public class LeetCode387 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (times[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
