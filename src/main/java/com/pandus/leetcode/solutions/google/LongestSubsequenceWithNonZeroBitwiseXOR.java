package com.pandus.leetcode.solutions.google;

public class LongestSubsequenceWithNonZeroBitwiseXOR {
    public int longestSubsequence(int[] nums) {
        int x = 0;
        for (int v : nums) x ^= v;

        if (x != 0)
            return nums.length;

        for (int v : nums) {
            if (v != 0)
                return nums.length - 1;
        }
        return 0;
    }
}
