import java.util.HashSet;
import java.util.Set;

/**
 * @author songshiyu 最小基因变化
 * @create: 2021/4/23 09:27:59
 **/
public class LeetCode433_2 {

    int minStepCounts = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0 || start.length() != end.length()) {
            return -1;
        }

        solve(start, end, bank, 0, new HashSet<String>());
        return minStepCounts == Integer.MAX_VALUE ? -1 : minStepCounts;
    }

    private void solve(String current, String target, String[] bank, int stepCount, Set<String> steps) {

        if (current.equals(target)) {
            minStepCounts = Math.min(minStepCounts, stepCount);
            return;
        }

        for (String str : bank) {
            int different = 0;
            if (str.length() != current.length()) {
                continue;
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != current.charAt(i)) {
                    different++;
                    if (different > 1) {
                        break;
                    }
                }
            }
            if (different == 1 && !steps.contains(str)) {
                steps.add(str);
                solve(str, target, bank, stepCount + 1, steps);
                steps.remove(str);
            }
        }
    }
}
