package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct
class MinimumNumberOperationsToMakeElementsInArrayDistinct {
    fun minimumOperations(nums: IntArray): Int {
        val seen = mutableSetOf<Int>()
        for (i in nums.indices.reversed()) {
            if (!seen.add(nums[i])) {
                return i / 3 + 1
            }
        }
        return 0
    }
}
