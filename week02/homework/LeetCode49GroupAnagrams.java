//输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]

import java.util.*;

/**
 * @author songshiyu
 * @date 2021/4/10 15:59
 **/
public class LeetCode49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> resultMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] keyChars = strs[i].toCharArray();
            Arrays.sort(keyChars);
            String key = new String(keyChars);
            List<String> valueList = resultMap.getOrDefault(key, new ArrayList<>());
            valueList.add(strs[i]);
            resultMap.put(key, valueList);
        }
        return new ArrayList<>(resultMap.values());
    }
}
