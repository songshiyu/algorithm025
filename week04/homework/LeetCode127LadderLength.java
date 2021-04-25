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
import java.util.*;

/**
 * @author songshiyu 单词接龙 
 * @date 2021/4/25 19:57
 **/
public class LeetCode127LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            visited[idx] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ++count;
            while (size-- > 0) {
                String start = queue.poll();
                for (int i = 0; i < wordList.size(); ++i) {
                    if (visited[i]) {
                        continue;
                    }
                    String s = wordList.get(i);
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    visited[i] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
