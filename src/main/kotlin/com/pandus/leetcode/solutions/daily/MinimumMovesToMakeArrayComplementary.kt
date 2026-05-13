package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-moves-to-make-array-complementary
class MinimumMovesToMakeArrayComplementary {
    fun minMoves(nums: IntArray, limit: Int): Int {
        val n = nums.size
        val diff = IntArray(2 * limit + 2)

        for (i in 0 until n / 2) {
            val a = nums[i]
            val b = nums[n - 1 - i]
            val sum = a + b
            val lo = minOf(a, b) + 1
            val hi = maxOf(a, b) + limit

            // Base: 2 moves for all T
            diff[2] += 2
            // 1 move for T in [lo, hi]
            diff[lo] -= 1
            if (hi + 1 <= 2 * limit) diff[hi + 1] += 1
            // 0 moves for T == sum
            diff[sum] -= 1
            diff[sum + 1] += 1
        }

        var result = n
        var cur = 0
        for (t in 2..2 * limit) {
            cur += diff[t]
            result = minOf(result, cur)
        }
        return result
    }
}
