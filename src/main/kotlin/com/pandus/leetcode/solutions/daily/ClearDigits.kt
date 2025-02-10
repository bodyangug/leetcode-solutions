package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/clear-digits
class ClearDigits {
    fun clearDigits(s: String) = buildString {
        for (c in s) if (!c.isDigit()) append(c)
        else if (isNotEmpty()) setLength(lastIndex)
    }
}
