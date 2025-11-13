package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end
class MaximumNumberOfOperationsToMoveOnesToTheEnd {
    fun maxOperations(s: String): Int {
        var countOne = 0
        var ans = 0
        var i = 0
        while (i < s.length) {
            if (s[i] == '0') {
                while (i + 1 < s.length && s[i + 1] == '0') {
                    i++
                }
                ans += countOne
            } else {
                countOne++
            }
            i++
        }
        return ans
    }
}
