package pers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146
 */
public class LRUCache {

    private Map<Integer, Integer> value;

    private int maxCapacity;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        value = new LinkedHashMap(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > maxCapacity;
            }
        };
    }

    public int get(int key) {
        Integer integer = value.get(key);
        if (integer == null) {
            return -1;
        }
        return integer;
    }

    public void put(int key, int value) {
        this.value.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,1);
        lruCache.get(2);
        lruCache.put(3,1);
        System.out.println(lruCache.get(1));
    }
}
