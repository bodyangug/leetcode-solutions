package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-length-of-string-after-operations
class MinimumLengthOfStringAfterOperations {
    fun minimumLength(s: String): Int = s.groupBy { it }
        .values
        .sumOf { 2 - it.size % 2 }
}
