import java.util.LinkedHashMap;

/**
 * @description: LRU 缓存机制
 * @create: 2021/6/9 14:16:11
 **/
public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        map.remove(key);
    }

}
