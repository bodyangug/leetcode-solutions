package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/count-the-hidden-sequences
class CountHiddenSequences {
    fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
        var x = 0
        var y = 0
        var cur = 0
        for (d in differences) {
            cur += d
            x = min(x, cur)
            y = max(y, cur)
            if (y - x > upper - lower) {
                return 0
            }
        }
        return (upper - lower) - (y - x) + 1
    }
}
