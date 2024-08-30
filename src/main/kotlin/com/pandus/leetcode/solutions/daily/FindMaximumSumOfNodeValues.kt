package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/find-the-maximum-sum-of-node-values
class FindMaximumSumOfNodeValues {
    fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray?>?): Long {
        val memo = Array(nums.size) { LongArray(2) { -1 } }
        return maxSumOfNodes(0, 1, nums, k, memo)
    }

    private fun maxSumOfNodes(
        index: Int,
        isEven: Int,
        nums: IntArray,
        k: Int,
        memo: Array<LongArray>
    ): Long {
        if (index == nums.size) {
            // If the operation is performed on an odd number of elements return
            // INT_MIN
            return if (isEven == 1) 0 else Int.MIN_VALUE.toLong()
        }
        if (memo[index][isEven] != -1L) {
            return memo[index][isEven]
        }
        // No operation performed on the element
        val noXorDone = nums[index] + maxSumOfNodes(index + 1, isEven, nums, k, memo)
        // XOR operation is performed on the element
        val xorDone = (nums[index] xor k) + maxSumOfNodes(index + 1, isEven xor 1, nums, k, memo)
        // Memoize and return the result
        return max(xorDone, noXorDone).also { memo[index][isEven] = it }.toLong()
    }
}
