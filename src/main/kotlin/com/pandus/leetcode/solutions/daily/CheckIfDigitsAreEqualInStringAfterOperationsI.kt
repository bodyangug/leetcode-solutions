package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i
class CheckIfDigitsAreEqualInStringAfterOperationsI {
    fun hasSameDigits(s: String): Boolean {
        val digits = IntArray(s.length) { idx -> s[idx] - '0' }

        var lastIndex = digits.lastIndex
        while (lastIndex > 1) {
            for (i in 0 until lastIndex) {
                digits[i] = (digits[i] + digits[i + 1]) % 10
            }
            lastIndex--
        }
        return digits[0] == digits[1]
    }
}
