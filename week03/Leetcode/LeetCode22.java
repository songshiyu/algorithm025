//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//        示例 1：
//        输入：n = 3
//        输出：["((()))","(()())","(())()","()(())","()()()"]
//
//        示例 2：
//        输入：n = 1
//        输出：["()"]


import java.util.ArrayList;
import java.util.List;

/**
 * @author songshiyu  括号生成
 * @date 2021/4/12 23:01
 **/
public class LeetCode22 {

    static List<String> result;

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generateParenthesis(0, 0, n, "");
        return result;
    }

    public static void generateParenthesis(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            generateParenthesis(left + 1, right, n, s + "(");
        }
        if (right < left) {
            generateParenthesis(left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(3);
    }
}
