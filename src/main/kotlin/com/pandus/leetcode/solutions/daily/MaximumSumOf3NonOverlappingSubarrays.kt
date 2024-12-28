package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays
class MaximumSumOf3NonOverlappingSubarrays {
    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        val n = nums.size - k + 1
        val sums = calculateWindowSums(nums, k)

        val memo = Array(n) { IntArray(4) { -1 } }
        val indices = mutableListOf<Int>()

        dp(sums, k, 0, 3, memo)

        reconstructPath(sums, k, 0, 3, memo, indices)
        return indices.take(3).toIntArray()
    }

    private fun calculateWindowSums(nums: IntArray, k: Int): IntArray {
        val n = nums.size - k + 1
        val sums = IntArray(n)
        var windowSum = nums.take(k).sum()

        sums[0] = windowSum

        for (i in k until nums.size) {
            windowSum = windowSum - nums[i - k] + nums[i]
            sums[i - k + 1] = windowSum
        }
        return sums
    }

    private fun dp(sums: IntArray, k: Int, idx: Int, rem: Int, memo: Array<IntArray>): Int {
        if (rem == 0) return 0
        if (idx >= sums.size) return Int.MIN_VALUE

        if (memo[idx][rem] != -1) return memo[idx][rem]

        val takeCurrent = sums[idx] + dp(sums, k, idx + k, rem - 1, memo)
        val skipCurrent = dp(sums, k, idx + 1, rem, memo)

        memo[idx][rem] = maxOf(takeCurrent, skipCurrent)
        return memo[idx][rem]
    }

    private fun reconstructPath(
        sums: IntArray,
        k: Int,
        idx: Int,
        rem: Int,
        memo: Array<IntArray>,
        indices: MutableList<Int>
    ) {
        if (rem == 0 || idx >= sums.size) return
        val takeCurrent = sums[idx] + dp(sums, k, idx + k, rem - 1, memo)
        val skipCurrent = dp(sums, k, idx + 1, rem, memo)

        if (takeCurrent >= skipCurrent) {
            indices.add(idx)
            reconstructPath(sums, k, idx + k, rem - 1, memo, indices)
        } else {
            reconstructPath(sums, k, idx + 1, rem, memo, indices)
        }
    }
}
