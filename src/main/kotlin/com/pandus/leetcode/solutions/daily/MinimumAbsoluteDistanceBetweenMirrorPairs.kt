package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs
class MinimumAbsoluteDistanceBetweenMirrorPairs {
    fun minMirrorPairDistance(nums: IntArray): Int {
        val prev: MutableMap<Int, Int> = HashMap()
        val n = nums.size
        var ans = n + 1

        for (i in 0..<n) {
            val x = nums[i]
            if (prev.containsKey(x)) {
                ans = min(ans, i - prev[x]!!)
            }
            prev[reverseNum(x)] = i
        }

        return if (ans == n + 1) -1 else ans
    }

    private fun reverseNum(x: Int): Int {
        var x = x
        var y = 0
        while (x > 0) {
            y = y * 10 + (x % 10)
            x /= 10
        }
        return y
    }
}
