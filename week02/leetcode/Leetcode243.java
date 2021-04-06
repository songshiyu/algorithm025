//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//示例 1:
//输入: s = "anagram", t = "nagaram"
//输出: true

//示例 2:
//输入: s = "rat", t = "car"
//输出: false

//说明:
//你可以假设字符串只包含小写字母。


import java.util.Arrays;

/**
 * 有效的字母异位词:每个字符出现的次数是否相同，不区分大小写
 *
 * @author songshiyu
 * @date 2021/4/5 9:02
 **/
public class Leetcode243 {

    /**
     * 对s、t进行排序，比较排序后的组成的字符串是否相等
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toLowerCase().toCharArray();
        char[] tchars = t.toLowerCase().toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        return Arrays.equals(schars, tchars);
    }

    /**
     * 利用hash表
     * 使用数组作为hash表，创建一个大小为26的数组，两次循环，根据对应索引上的值是否小于0，
     * 来判断两个字符串是否为有效的字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aacc", t = "ccac";
        isAnagram2(s, t);
    }
}
