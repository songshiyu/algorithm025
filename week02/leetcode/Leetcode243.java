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
     * 利用hash表 TODO
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        String[] array = new String[26];
        return false;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        isAnagram(s, t);
    }
}
