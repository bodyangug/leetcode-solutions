package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid
class MinimumOperationsToMakeUniValueGrid {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val nums = grid.flatMap { it.asList() }.sorted()
        val median = nums[nums.size / 2]

        return if (nums.any { (it - median) % x != 0 }) {
            -1
        } else {
            nums.sumOf { abs(it - median) / x }
        }
    }
}
