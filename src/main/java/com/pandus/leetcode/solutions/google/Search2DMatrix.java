package com.pandus.leetcode.solutions.google;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = findInMatrix(matrix, target);
        if (r == matrix.length) return false;
        int c = findInRow(matrix[r], target);
        return matrix[r][c] == target;
    }

    private int findInMatrix(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (matrix[mid][matrix[0].length - 1] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int findInRow(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
