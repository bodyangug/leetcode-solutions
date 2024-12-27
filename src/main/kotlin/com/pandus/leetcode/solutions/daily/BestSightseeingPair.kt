package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/best-sightseeing-pair
class BestSightseeingPair {
    fun maxScoreSightseeingPair(values: IntArray): Int {
        var p = 0
        return values.withIndex().maxOf { (i, n) ->
            (n - i + p).also { p = max(p, i + n) }
        }
    }
}
