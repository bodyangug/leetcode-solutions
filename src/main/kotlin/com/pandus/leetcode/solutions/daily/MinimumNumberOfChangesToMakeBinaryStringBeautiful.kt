package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful
class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    fun minChanges(s: String): Int {
        var currentChar = s[0]
        var consecutiveCount = 0
        var minChangesRequired = 0

        for (i in s.indices) {
            if (s[i] == currentChar) {
                consecutiveCount++
                continue
            }

            if (consecutiveCount % 2 == 0) {
                consecutiveCount = 1
            } else {
                consecutiveCount = 0
                minChangesRequired++
            }
            currentChar = s[i]
        }
        return minChangesRequired
    }
}
