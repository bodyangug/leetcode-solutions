package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

class MaximumFrequencyOfElementAfterPerformingOperationsII {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        if (nums.isEmpty()) return 0
        nums.sort()

        val frequency = buildFrequencyMap(nums)

        val candidates = buildCandidates(frequency.keys, nums.first(), nums.last(), k)

        var maxFreq = 0
        for (value in frequency.values) maxFreq = max(maxFreq, value)

        for (mode in candidates) {
            val leftIndex = lowerBound(nums, mode - k) // first index with value >= mode - k
            val rightIndex = upperBound(nums, mode + k) // last index with value <= mode + k
            if (leftIndex > rightIndex) continue // No numbers can reach this mode.

            val windowSize = rightIndex - leftIndex + 1
            val possible = if (frequency.containsKey(mode)) frequency[mode]!! + numOperations else numOperations
            maxFreq = max(maxFreq, min(windowSize, possible))
        }

        return maxFreq
    }

    private fun buildFrequencyMap(nums: IntArray): MutableMap<Int, Int> {
        val freq = mutableMapOf<Int, Int>()
        var start = 0
        for (i in nums.indices) {
            if (nums[i] != nums[start]) {
                freq[nums[start]] = i - start
                start = i
            }
        }
        freq[nums[start]] = nums.size - start
        return freq
    }

    private fun buildCandidates(distinct: Set<Int>, minVal: Int, maxVal: Int, k: Int): Set<Int> {
        val set = mutableSetOf<Int>()
        for (v in distinct) {
            set.add(v)
            val minus = v - k
            val plus = v + k
            if (minus >= minVal) set.add(minus)
            if (plus <= maxVal) set.add(plus)
        }
        return set
    }

    private fun lowerBound(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size
        while (l < r) {
            val mid = (l + r) ushr 1
            if (nums[mid] < target) l = mid + 1 else r = mid
        }
        return l
    }

    private fun upperBound(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size
        while (l < r) {
            val mid = (l + r) ushr 1
            if (nums[mid] <= target) l = mid + 1 else r = mid
        }
        return l - 1
    }
}
