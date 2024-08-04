package com.pandus.leetcode.solutions.daily

import kotlin.math.min

//Reference: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced
class MinimumDeletionsToMakeStringBalanced {
    fun minimumDeletions(s: String): Int {
        val n = s.length
        val countA = IntArray(n)
        val countB = IntArray(n)

        // First pass: compute count_b which stores the number of
        // 'b' characters to the left of the current position.
        var bCount = 0
        for (i in 0 until n) {
            countB[i] = bCount
            if (s[i] == 'b') bCount++
        }

        // Second pass: compute count_a which stores the number of
        // 'a' characters to the right of the current position
        var aCount = 0
        for (i in n - 1 downTo 0) {
            countA[i] = aCount
            if (s[i] == 'a') aCount++
        }

        // Third pass: iterate through the string to find the minimum deletions
        var minDeletions = n
        for (i in 0 until n) {
            minDeletions = min(minDeletions, (countA[i] + countB[i]))
        }
        return minDeletions
    }
}