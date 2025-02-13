package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii
class MinimumOperationsToExceedThresholdValueII {
    fun minOperations(nums: IntArray, k: Int): Int {
        val q = PriorityQueue(nums.map { 1L * it })
        while (q.peek() < k) q += q.poll() * 2 + q.poll()
        return nums.size - q.size
    }
}
