package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string
class MinimumChangesToMakeAlternatingBinaryString {
    fun minOperations(s: String): Int {
        var count1 = 0
        var count2 = 0
        for (i in s.indices) {
            if (s[i] - '0' != i % 2) {
                count1++
            } else {
                count2++
            }
        }
        return count1.coerceAtMost(count2)
    }
}
