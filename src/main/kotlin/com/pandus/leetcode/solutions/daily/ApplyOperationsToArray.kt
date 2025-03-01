package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/apply-operations-to-an-array
class ApplyOperationsToArray {
    fun applyOperations(nums: IntArray): IntArray {
        val n = nums.size
        var nonZeroIndex = 0

        // Apply operations and shift non-zero elements in one pass
        for (i in 0 until n - 1) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2
                nums[i + 1] = 0
            }
            if (nums[i] != 0) nums[nonZeroIndex++] = nums[i]
        }

        // Handle last element separately if non-zero
        if (nums[n - 1] != 0) nums[nonZeroIndex++] = nums[n - 1]

        // Fill remaining positions with zeros
        nums.fill(0, nonZeroIndex, n)

        return nums
    }
}
