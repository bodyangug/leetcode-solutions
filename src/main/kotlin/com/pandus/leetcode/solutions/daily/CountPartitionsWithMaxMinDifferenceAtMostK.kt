package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k
class CountPartitionsWithMaxMinDifferenceAtMostK {
    fun countPartitions(nums: IntArray, k: Int): Int {
        val mod = 1_000_000_007L
        val n = nums.size

        val dp = LongArray(n + 1)
        val prefixSum = LongArray(n + 1)
        val frequencyMap = TreeMap<Int, Int>()

        dp[0] = 1
        prefixSum[0] = 1

        var windowStart = 0

        for (windowEnd in nums.indices) {
            addToWindow(frequencyMap, nums[windowEnd])

            windowStart = shrinkWindowIfNeeded(
                frequencyMap,
                nums,
                windowStart,
                windowEnd,
                k
            )

            dp[windowEnd + 1] = calculatePartitions(prefixSum, windowStart, windowEnd, mod)
            prefixSum[windowEnd + 1] = (prefixSum[windowEnd] + dp[windowEnd + 1]) % mod
        }

        return dp[n].toInt()
    }

    private fun addToWindow(map: TreeMap<Int, Int>, value: Int) {
        map[value] = map.getOrDefault(value, 0) + 1
    }

    private fun removeFromWindow(map: TreeMap<Int, Int>, value: Int) {
        val count = map[value]!! - 1
        if (count == 0) {
            map.remove(value)
        } else {
            map[value] = count
        }
    }

    private fun shrinkWindowIfNeeded(
        frequencyMap: TreeMap<Int, Int>,
        nums: IntArray,
        start: Int,
        end: Int,
        maxDiff: Int
    ): Int {
        var windowStart = start

        while (windowStart <= end && getRange(frequencyMap) > maxDiff) {
            removeFromWindow(frequencyMap, nums[windowStart])
            windowStart++
        }

        return windowStart
    }

    private fun getRange(map: TreeMap<Int, Int>): Int {
        return if (map.isEmpty()) 0 else map.lastKey() - map.firstKey()
    }

    private fun calculatePartitions(
        prefixSum: LongArray,
        windowStart: Int,
        windowEnd: Int,
        mod: Long
    ): Long {
        val rangeSum = prefixSum[windowEnd] - (if (windowStart > 0) prefixSum[windowStart - 1] else 0)
        return (rangeSum + mod) % mod
    }
}
