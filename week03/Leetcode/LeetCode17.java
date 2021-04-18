import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songshiyu 电话号码的字母组合
 * @date 2021/4/18 9:22
 **/
public class LeetCode17 {

    private Map<Character, String> dict = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        letterCombinations(result, digits, 0, new StringBuffer());
        return result;
    }

    private void letterCombinations(List<String> result, String digits, int index, StringBuffer element) {
        if (index == digits.length()) {
            result.add(element.toString());
            return;
        }
        String innerElement = dict.get(digits.charAt(index));
        for (int i = 0; i < innerElement.length(); i++) {
            element.append(innerElement.charAt(i));
            letterCombinations(result, digits, index + 1, element);
            element.deleteCharAt(index);
        }
    }
}
