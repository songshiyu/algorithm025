/**
 * @description: 58. 最后一个单词的长度
 * @create: 2021/5/31 09:41:20
 **/
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        //由于题目要求最后一个单词的长度，因此可以直接由后向前遍历
        int length = s.length() - 1;
        //1.首先移除字符串末尾的所有空格
        while (length >= 0 && s.charAt(length) == ' ') {
            length--;
        }
        if (length < 0) {
            return 0;
        }

        int start = length;
        //遍历字符串，直到遇见第一个空格
        while (length >= 0 && s.charAt(length) != ' ') {
            length--;
        }
        return start - length;
    }
}
