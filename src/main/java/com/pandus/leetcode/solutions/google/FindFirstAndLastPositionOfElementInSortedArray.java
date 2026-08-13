package com.pandus.leetcode.solutions.google;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int lowerBound = find(nums, target);
        if (lowerBound == nums.length || nums[lowerBound] != target) {
            return new int[]{-1, -1};
        }
        int upperBound = find(nums, target + 1) - 1;
        return new int[]{lowerBound, upperBound};
    }

    private int find(int nums[], int n) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] >= n) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
