package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/unique-number-of-occurrences
class UniqueNumberOfOccurrences {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        return arr.groupBy { it }
            .map { it.value.size }
            .let { it.size == it.toSet().size }
    }
}
