package pers;

import java.util.HashMap;
import java.util.Map;

public class Stack {

    public boolean isValid(String s) {
        Map<Character, Character> ma = new HashMap<>();
        ma.put(')', '(');
        ma.put(']', '{');
        ma.put('}', '{');
        java.util.Stack<Character> st = new java.util.Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (ma.keySet().contains(s.charAt(i))) {
                char c = st.peek();
                if (c == ma.get(s.charAt(i))) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        return true;
    }

}
