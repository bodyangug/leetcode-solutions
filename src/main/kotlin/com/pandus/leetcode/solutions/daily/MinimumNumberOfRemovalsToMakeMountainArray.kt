package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array
class MinimumNumberOfRemovalsToMakeMountainArray {
    fun minimumMountainRemovals(nums: IntArray): Int {
        val N = nums.size
        val lisLength = IntArray(N) { 1 }
        val ldsLength = IntArray(N) { 1 }

        for (i in 0 until N) {
            for (j in i - 1 downTo 0) {
                if (nums[i] > nums[j]) {
                    lisLength[i] = max(lisLength[i], (lisLength[j] + 1))
                }
            }
        }

        for (i in N - 1 downTo 0) {
            for (j in i + 1 until N) {
                if (nums[i] > nums[j]) {
                    ldsLength[i] = max(ldsLength[i], (ldsLength[j] + 1))
                }
            }
        }

        var minRemovals = Int.MAX_VALUE
        for (i in 0 until N) {
            if (lisLength[i] > 1 && ldsLength[i] > 1) {
                minRemovals = min(minRemovals, (N - lisLength[i] - ldsLength[i] + 1))
            }
        }

        return minRemovals
    }
}
