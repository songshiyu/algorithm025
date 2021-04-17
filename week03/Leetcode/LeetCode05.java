//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//        示例 1：
//        输入：s = "We are happy."
//        输出："We%20are%20happy."


/**
 * @author songshiyu 剑指 Offer 05. 替换空格
 * @date 2021/4/15 21:01
 **/
public class LeetCode05 {

    public String replaceSpace(String s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
