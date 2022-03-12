package pers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Stacks {

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

    /**394
     * @param s
     * @return
     */
    public String decodeString(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                adjust(stack);
            } else {
                stack.addLast(s.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            builder.append(stack.get(i));
        }
        return builder.toString();
    }

    private void adjust(LinkedList<Character> stack) {
        StringBuilder repleteStr = new StringBuilder();
        while (!stack.isEmpty()) {
            Character character = stack.removeLast();
            if (character == '[') {
                break;
            } else {
                repleteStr.append(character);
            }
        }
        repleteStr.reverse();
        StringBuilder timeStr = new StringBuilder();
        while (!stack.isEmpty()) {
            Character character = stack.removeLast();
            if (character < '0' || character > '9') {
                stack.add(character);
                break;
            } else {
                timeStr.append(character);
            }
        }
        int time = Integer.parseInt(timeStr.reverse().toString());
        StringBuilder repleteStrRes = new StringBuilder();
        while (time > 0) {
            repleteStrRes.append(repleteStr);
            time--;
        }
        String s = repleteStrRes.toString();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
        }
    }

}
