package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/continuous-subarrays
class ContinuousSubarrays {
    fun continuousSubarrays(nums: IntArray): Long {
        val s = TreeSet<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
        var j = 0
        return nums.withIndex().sumOf { (i, n) ->
            s += n to i
            while (s.last().first - s.first().first > 2) s -= nums[j] to j++
            1L + i - j
        }
    }
}
