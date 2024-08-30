package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii
class MinimumNumberOfPushesToTypeWordII {
    fun minimumPushes(word: String): Int {
        val frequency = IntArray(26).apply {
            word.forEach { c ->
                this[c.code - 'a'.code]++
            }
        }
        val sortedFrequency = frequency.sortedArrayDescending()
        return sortedFrequency
            .takeWhile { it != 0 }
            .mapIndexed { index, value -> (index / 8 + 1) * value }
            .sum()
    }
}
