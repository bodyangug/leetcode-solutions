package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/zero-array-transformation-ii
class ZeroArrayTransformationII {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        val q = queries.size

        if (!canZeroUpToK(nums, queries, q)) return -1

        var left = 0
        var right = q

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (canZeroUpToK(nums, queries, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun canZeroUpToK(nums: IntArray, queries: Array<IntArray>, k: Int): Boolean {
        val n = nums.size
        val diff = IntArray(n + 1)

        for (i in 0 until k) {
            val l = queries[i][0]
            val r = queries[i][1]
            val v = queries[i][2]

            diff[l] += v
            if (r + 1 < diff.size) {
                diff[r + 1] -= v
            }
        }

        var running = 0
        for (i in 0 until n) {
            running += diff[i]
            if (running < nums[i]) {
                return false
            }
        }
        return true
    }
}
