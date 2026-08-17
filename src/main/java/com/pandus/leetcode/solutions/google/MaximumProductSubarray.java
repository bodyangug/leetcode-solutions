package com.pandus.leetcode.solutions.google;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int best = nums[0];
        int worst = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            int cand1 = current;
            int cand2 = best * current;
            int cand3 = worst * current;

            int newBest = Math.max(cand1, Math.max(cand2, cand3));
            int newWorst = Math.min(cand1, Math.min(cand2, cand3));
            best = newBest;
            worst = newWorst;
            ans = Math.max(ans, best);
        }
        return ans;
    }
}
