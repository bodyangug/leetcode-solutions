package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/k-th-smallest-in-lexicographical-order
class KthSmallestInLexicographicalOrder {

    fun findKthNumber(n: Int, k: Int): Int {
        var remainingK = k - 1L
        var current = 1L

        while (remainingK > 0) {
            val steps = calculateSteps(n.toLong(), current, current + 1)
            if (steps <= remainingK) {
                current += 1
                remainingK -= steps
            } else {
                current *= 10
                remainingK -= 1
            }
        }
        return current.toInt()
    }

    private fun calculateSteps(n: Long, firstPrefix: Long, nextPrefix: Long): Long {
        var steps = 0L
        var first = firstPrefix
        var last = nextPrefix

        while (first <= n) {
            steps += minOf(n + 1, last) - first
            first *= 10
            last *= 10
        }
        return steps
    }
}
