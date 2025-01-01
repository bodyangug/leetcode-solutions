package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-score-after-splitting-a-string
class MaximumScoreAfterSplittingString {
    fun maxScore(s: String): Int {
        var ans = 0
        for (i in 0 until s.length - 1) {
            var curr = 0
            for (j in 0..i) {
                if (s[j] == '0') {
                    curr++
                }
            }
            for (j in i + 1 until s.length) {
                if (s[j] == '1') {
                    curr++
                }
            }
            ans = max(ans, curr)
        }
        return ans
    }
}
