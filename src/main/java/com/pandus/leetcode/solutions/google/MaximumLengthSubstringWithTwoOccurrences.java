package com.pandus.leetcode.solutions.google;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> windowState = new HashMap<>();
        char[] chars = s.toCharArray();
        int ans = 0;
        int left = 0;
        for (char c : chars) {
            while (!windowState.isEmpty()
                    && windowState.containsKey(c)
                    && windowState.get(c) > 2) {
                left++;
                char l = chars[left];
                windowState.put(l, windowState.getOrDefault(l, 0) - 1);
                if (windowState.get(l) == 0) {
                    windowState.remove(l);
                }
            }
            windowState.put(c, windowState.getOrDefault(c, 0) + 1);
        }
        return ans;
    }
}
