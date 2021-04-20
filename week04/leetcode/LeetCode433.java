//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
//假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
//例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
//与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
//现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，
// 请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
// 注意：
//    起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
//    如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。
//    假定起始基因序列与目标基因序列是不一样的。
//
//        示例 1：
//        start: "AACCGGTT"
//        end:   "AACCGGTA"
//        bank: ["AACCGGTA"]
//        返回值: 1
//
//        示例 2：
//        start: "AACCGGTT"
//        end:   "AAACGGTA"
//        bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//        返回值: 2
//
//        示例 3：
//        start: "AAAAACCC"
//        end:   "AACCCCCC"
//        bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//        返回值: 3

import java.util.Arrays;

/**
 * @author songshiyu 最小基因变化 TODO 以下解法是错误的
 * @create: 2021/4/20 09:12:02
 **/
public class LeetCode433 {

    /**
     * 第一次理解：找start与end中相同索引位置上，元素不相同的个数
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public static int minMutation(String start, String end, String[] bank) {

        if (start.length() != end.length() || bank.length == 0 || !Arrays.asList(bank).contains(end)) {
            return -1;
        }
        int minStep = 0;

        char[] startChars = start.toCharArray();
        for (int i = 0; i < start.length(); i++) {
            if (startChars[i] != end.charAt(i)) {
                startChars[i] = end.charAt(i);
                if (Arrays.asList(bank).contains(new String(startChars))) {
                    minStep++;
                } else {
                    return -1;
                }
            }
        }
        return minStep;
    }

    public static void main(String[] args) {
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation("AACCGGTT", "AACCGGTA", bank));
    }
}
