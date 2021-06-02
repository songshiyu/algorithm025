import java.util.ArrayList;
import java.util.List;

/**
 * @description: 括号生成
 * @create: 2021/6/1 17:51:37
 **/
public class LeetCode22_2 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        solve(result, n, 0, 0, "");
        return result;
    }

    private void solve(List<String> result, int n, int left, int right, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (right < left) {
            solve(result, n, left, right + 1, s + ")");
        }

        if (left < n) {
            solve(result, n, left + 1, right, s + "(");
        }
    }

    public static void main(String[] args) {
        LeetCode22_2 leetCode22_2 = new LeetCode22_2();
        leetCode22_2.generateParenthesis(3);
    }
}
