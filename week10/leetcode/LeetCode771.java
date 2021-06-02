import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @create: 2021/5/31 10:39:22
 **/
public class LeetCode771 {

    /**
     * HashMap
     *
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {

        if (stones == "" || stones.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < stones.length(); i++) {
            map.put(stones.charAt(i), map.getOrDefault(stones.charAt(i), 0) + 1);
        }

        int result = 0;
        for (int i = 0; i < jewels.length(); i++) {
            result += map.getOrDefault(jewels.charAt(i), 0);
        }
        return result;
    }

    /**
     * Set
     *
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones2(String jewels, String stones) {
        int result = 0;
        if (stones == null || stones.length() == 0) {
            return result;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}
