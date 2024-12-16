package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i
class FinalArrayAfterKMultiplicationOperationsI {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val n = nums.size
        for (j in 0 until k) {
            var minIndex = 0
            for (i in 0 until n) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i
                }
            }
            nums[minIndex] *= multiplier
        }
        return nums
    }
}
