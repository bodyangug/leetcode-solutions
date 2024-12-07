package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/move-pieces-to-obtain-a-string
class MovePiecesToObtainString {
    fun canChange(start: String, target: String): Boolean {
        var l = 0
        var r = 0
        for ((i, s) in start.withIndex()) {
            val t = target[i]
            if (s == 'R') r++
            if (t == 'L') l++
            if (l * r > 0) return false
            if (t == 'R' && --r < 0) return false
            if (s == 'L' && --l < 0) return false
        }
        return l == 0 && r == 0
    }
}
