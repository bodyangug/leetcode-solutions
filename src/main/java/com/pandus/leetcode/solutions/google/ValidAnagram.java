package com.pandus.leetcode.solutions.google;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.containsKey(curr)) {
                int temp = map.get(curr) + 1;
                map.put(curr, temp);
            } else {
                map.put(curr, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);

            if (map.containsKey(curr)) {
                int temp = map.get(curr) - 1;
                if (temp == 0) {
                    map.remove(curr);
                } else {
                    map.put(curr, temp);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
