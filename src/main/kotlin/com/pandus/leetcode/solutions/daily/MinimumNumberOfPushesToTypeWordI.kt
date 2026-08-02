package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i
class MinimumNumberOfPushesToTypeWordI {
    fun minimumPushes(word: String): Int {
        val counts = IntArray(26)
        for (ch in word) {
            counts[ch - 'a']++
        }
        val sortedCounts = counts.filter { it > 0 }.sortedDescending()
        var pushes = 0
        for (i in sortedCounts.indices) {
            pushes += (i / 8 + 1) * sortedCounts[i]
        }
        return pushes
    }
}
