//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
//        序列中第一个单词是 beginWord 。
//        序列中最后一个单词是 endWord 。
//        每次转换只能改变一个字母。
//        转换过程中的中间单词必须是字典 wordList 中的单词。
//        给你两个单词 beginWord和endWord和一个字典wordList，找到从beginWord到endWord的最短转换序列中的单词数目。
// 如果不存在这样的转换序列，返回 0。
//         
//        示例 1：
//        输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//        输出：5
//        解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
//
//        示例 2：
//        输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//        输出：0
//        解释：endWord "cog" 不在字典中，所以无法进行转换。

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author songshiyu 单词接龙 TODO 有疑问
 * @date 2021/4/25 19:57
 **/
public class LeetCode127LadderLength {

    static int minStep = Integer.MAX_VALUE;

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }
        if (beginWord.length() == 1 && endWord.length() == 1 && wordList.contains(endWord)) {
            return 1;
        }
        solve(beginWord, endWord, wordList, 0, new HashSet<String>());
        return minStep == Integer.MAX_VALUE ? 0 : minStep;
    }

    private static void solve(String current, String target, List<String> wordList, int steps, Set<String> set) {
        if (current.equals(target)) {
            minStep = Math.min(minStep, steps - 1);
            return;
        }

        for (String word : wordList) {
            int different = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == current.charAt(i)) {
                    different++;
                    if (different > 1) {
                        break;
                    }
                }
            }
            if (different == 1 && !set.contains(word)) {
                set.add(word);
                solve(word, target, wordList, steps + 1, set);
            }
        }
    }

    public static void main(String[] args) {
        String[] wordList = {"a", "b", "c"};
        System.out.println(ladderLength("a", "c", Arrays.asList(wordList)));
    }
}
