package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaozhe
 * @date 2022/1/27
 */
public class MinStack {

    List<Integer> value = new ArrayList<>();
    List<Integer> minValue = new ArrayList<>();

    public void push(int i) {
        value.add(i);
        int min = this.getMin();
        if (i < min) {
            min = i;
        }
        minValue.add(min);
    }

    public int pop() {
        int res = value.remove(value.size() - 1);
        minValue.remove(minValue.size() - 1);
        return res;
    }

    public int top() {
        return value.get(value.size() - 1);
    }

    public int getMin() {
        if (minValue.size() == 0) {
            return Integer.MAX_VALUE;
        }
        return minValue.get(minValue.size() - 1);
    }

}
