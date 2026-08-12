package com.pandus.leetcode.solutions.google;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minL = Integer.MAX_VALUE;
        int temp = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            temp += nums[right];
            while (temp >= target) {
                minL = Math.min(minL, right - left + 1);
                temp -= nums[left];
                left++;
            }
        }
        if (minL == Integer.MAX_VALUE) return 0;
        return minL;
    }

    // TLE
    public int minSubArrayLen1(int target, int[] nums) {
        int minL = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp >= target) {
                    minL = Math.min(minL, j - i + 1);
                    break;
                }
            }
        }
        if (minL == Integer.MAX_VALUE) return 0;
        return minL;
    }
}
