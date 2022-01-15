package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaozhe
 * @date 2022/1/14
 */
public class MapSum {

    MapSum[] children;
    Map<String, Integer> map;
    int value;

    public MapSum() {
        children = new MapSum[26];
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int oldVal = val;
        if (map.get(key) != null) {
            val -= map.get(key);
        }
        map.put(key, oldVal);
        MapSum temp = this;
        for (int i = 0; i < key.length(); i++) {
            if (temp.children[key.charAt(i) - 'a'] == null) {
                temp.children[key.charAt(i) - 'a'] = new MapSum();
            }
            temp.children[key.charAt(i) - 'a'].value += val;
            temp = temp.children[key.charAt(i) - 'a'];
        }
    }

    public int sum(String prefix) {
        MapSum temp = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.children[prefix.charAt(i) - 'a'] == null) {
                return 0;
            }
            temp = temp.children[prefix.charAt(i) - 'a'];
        }
        return temp.value;
    }

}
