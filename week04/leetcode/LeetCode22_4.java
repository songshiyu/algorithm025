//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//   示例 1：
//   输入：n = 3
//   输出：["((()))","(()())","(())()","()(())","()()()"]
//
//   示例 2：
//   输入：n = 1
//   输出：["()"]

import java.util.ArrayList;
import java.util.List;

/**
 * @author songshiyu
 * @create: 2021/4/21 11:18:40
 **/
public class LeetCode22_4 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(result, n, 0, 0, "");
        return result;
    }

    private void solve(List<String> result, int n, int left, int right, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            solve(result, n, left + 1, right, s + "(");
        }

        if (right < left) {
            solve(result, n, left, right + 1, s + ")");
        }
    }
}
