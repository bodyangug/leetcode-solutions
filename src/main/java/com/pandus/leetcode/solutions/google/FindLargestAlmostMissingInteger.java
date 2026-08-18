package com.pandus.leetcode.solutions.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLargestAlmostMissingInteger {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int left = 0; left + k - 1 < nums.length; left++) {
            Set<Integer> set = new HashSet<>();
            for (int i = left; i < left + k; i++) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }
            }
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) ans = Math.max(ans, entry.getKey());
        }
        return ans;
    }
}
