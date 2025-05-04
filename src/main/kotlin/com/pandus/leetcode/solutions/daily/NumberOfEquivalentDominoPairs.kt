package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-equivalent-domino-pairs
class NumberOfEquivalentDominoPairs {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        val count = IntArray(100)
        var result = 0
        for ((a, b) in dominoes) {
            val key = minOf(a, b) * 10 + maxOf(a, b)
            result += count[key]
            count[key]++
        }
        return result
    }
}
