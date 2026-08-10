package com.pandus.leetcode.solutions.google;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!pairs.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pop().equals(pairs.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
