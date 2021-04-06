//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//        示例:
//        输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        说明：
//
//        所有输入均为小写字母。
//        不考虑答案输出的顺序。

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 *
 * @author songshiyu
 * @date 2021/4/5 9:08
 **/
public class Leetcode49 {

    /**
     * 排序结题
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strList = map.getOrDefault(key, new ArrayList<>());
            strList.add(str);
            map.put(key, strList);
        }
        return new ArrayList<>(map.values());
    }

}
