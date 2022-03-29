package pers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**队列
 * @author qiaozhe
 * @date 2022/3/29
 */
public class QueueBean {

    /**76
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        String res = "";
        int length = Integer.MAX_VALUE;
        int total = 0;
        int left = -1;
        int right = 0;
        Map<Character, Integer> cs = new HashMap<>();
        Map<Character, LinkedList<Integer>> posi = new HashMap<>();
        for (Character c : t.toCharArray()) {
            cs.merge(c, 1, Integer::sum);
            posi.put(c, new LinkedList<>());
        }
        PriorityQueue<Integer> list = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cs.containsKey(c)) {
                right = i;
                if (left == -1) {
                    left = i;
                }
                list.add(i);
                posi.get(c).addLast(i);
                if (cs.get(c) > 0) {
                    total++;
                }
                cs.put(c, cs.get(c) - 1);
                if (cs.get(c) < 0) {
                    Integer integer = posi.get(c).removeFirst();
                    list.remove(integer);
                    left = list.peek();
                }
                if (total == t.length() && right - left < length) {
                    res = s.substring(left, right + 1);
                    length = right - left;
                }
            }
        }
        return res;
    }

}
