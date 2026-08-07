package com.pandus.leetcode.solutions.google;

import java.util.HashMap;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> windowState = new HashMap<>();
        int maxWindowSize = 0;
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            int f1 = fruits[right];
            if (windowState.containsKey(f1)) {
                windowState.put(f1, windowState.get(f1) + 1);
            } else {
                windowState.put(f1, windowState.getOrDefault(f1, 0) + 1);
            }

            while (windowState.size() > 2) {
                int leftFruit = fruits[left];
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
