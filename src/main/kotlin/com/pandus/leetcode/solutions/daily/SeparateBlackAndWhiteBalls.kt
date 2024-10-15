package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/separate-black-and-white-balls
class SeparateBlackAndWhiteBalls {
    fun minimumSteps(s: String): Long {
        var whitePosition = 0
        var totalSwaps: Long = 0

        for (currentPos in s.indices) {
            if (s[currentPos] == '0') {
                totalSwaps += (currentPos - whitePosition)
                whitePosition++
            }
        }
        return totalSwaps
    }
}
