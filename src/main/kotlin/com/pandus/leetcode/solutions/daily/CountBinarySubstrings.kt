package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-binary-substrings
class CountBinarySubstrings {
    fun countBinarySubstrings(s: String): Int {
        var count = 0
        var prevRunLength = 0
        var currRunLength = 1

        for (i in 1 until s.length) {
            if (s[i] == s[i - 1]) {
                currRunLength++
            } else {
                count += minOf(prevRunLength, currRunLength)
                prevRunLength = currRunLength
                currRunLength = 1
            }
        }
        count += minOf(prevRunLength, currRunLength)
        return count
    }
}
