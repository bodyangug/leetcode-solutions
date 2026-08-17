package com.pandus.leetcode.solutions.google;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int ans = curMax;
        for (int i = 1; i < nums.length; i++) {
            if (curMax + nums[i] > nums[i]) {
                curMax += nums[i];
            } else {
                curMax = nums[i];
            }
            ans = Math.max(ans, curMax);
        }
        return ans;
    }
}
