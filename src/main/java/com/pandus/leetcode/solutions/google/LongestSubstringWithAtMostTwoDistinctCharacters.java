package com.pandus.leetcode.solutions.google;

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Integer, Integer> windowState = new HashMap<>();
        int maxWindowSize = 0;
        char[] chars = s.toCharArray();
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            int letter = chars[right];
            if (windowState.containsKey(letter)) {
                windowState.put(letter, windowState.get(letter) + 1);
            } else {
                windowState.put(letter, windowState.getOrDefault(letter, 0) + 1);
            }

            while (windowState.size() > 2) {
                int leftFruit = chars[left];
                windowState.put(leftFruit, windowState.get(leftFruit) - 1);
                if (windowState.get(leftFruit) == 0) {
                    windowState.remove(leftFruit);
                }
                left++;
            }
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
        }
        return maxWindowSize;
    }
}
