//字典 wordList中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
//  序列中第一个单词是 beginWord 。
//  序列中最后一个单词是 endWord 。
//  每次转换只能改变一个字母。
//  转换过程中的中间单词必须是字典 wordList 中的单词。
//  给你两个单词 beginWord 和 endWord 和一个字典 wordList,找到从 beginWord到endWord的最短转换序列中的单词数目。
//  如果不存在这样的转换序列，返回 0。
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
//
//        提示：
//        1 <= beginWord.length <= 10
//        endWord.length == beginWord.length
//        1 <= wordList.length <= 5000
//        wordList[i].length == beginWord.length
//        beginWord、endWord 和 wordList[i] 由小写英文字母组成
//        beginWord != endWord
//        wordList 中的所有字符串 互不相同

import java.util.*;

/**
 * @author songshiyu 单词接龙
 * @create: 2021/4/28 16:53:52
 **/
public class LeetCode127 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();

                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < endWord.length(); j++) {
                    char originChar = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originChar) {
                            continue;
                        }
                        charArray[j] = k;
                        String nextWord = String.valueOf(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }

                        }
                    }
                    charArray[j] = originChar;
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
