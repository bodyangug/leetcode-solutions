package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

//Reference: https://leetcode.com/problems/score-of-a-string
class ScoreOfString {
    fun scoreOfString(s: String): Int {
        var score = 0
        for (i in 0 until s.length - 1) {
            score += abs((s[i].code - s[i + 1].code))
        }
        return score
    }
}