package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

class MaximumFrequencyOfElementAfterPerformingOperationsI {
    fun maxFrequency(nums: IntArray, k: Int, extraOps: Int): Int {
        if (nums.isEmpty()) return 0
        nums.sort()

        val freqWithinK = HashMap<Int, Int>()
        var left = 0
        var right = 0
        var best = 0

        for (current in nums) {
            // Extend right bound: values within current + k
            while (right < nums.size && nums[right] <= current + k) {
                val v = nums[right]
                freqWithinK[v] = (freqWithinK[v] ?: 0) + 1
                right++
            }
            // Move left bound: exclude values below current - k
            while (left < nums.size && nums[left] < current - k) {
                val v = nums[left]
                freqWithinK[v] = freqWithinK[v]!! - 1
                left++
            }
            val windowSize = right - left
            val currentFreq = freqWithinK[current] ?: 0
            best = max(best, min(currentFreq + extraOps, windowSize))
        }

        // Second window: elements within distance 2*k
        left = 0
        var bestTwoK = 0
        for (rIdx in nums.indices) {
            while (nums[rIdx] - nums[left] > 2 * k) {
                left++
            }
            val windowSize = rIdx - left + 1
            bestTwoK = max(bestTwoK, min(windowSize, extraOps))
        }
        return max(best, bestTwoK)
    }
}
