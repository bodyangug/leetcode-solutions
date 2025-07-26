package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair
class MaximizeSubarraysAfterRemovingOneConflictingPair {
    fun maxSubarrays(n: Int, conflictingPairs: Array<IntArray>): Long {
        val minConflict1 = IntArray(n + 1) { Int.MAX_VALUE }
        val minConflict2 = IntArray(n + 1) { Int.MAX_VALUE }

        for ((u, v) in conflictingPairs) {
            val a = u.coerceAtMost(v)
            val b = u.coerceAtLeast(v)
            if (minConflict1[a] > b) {
                minConflict2[a] = minConflict1[a]
                minConflict1[a] = b
            } else if (minConflict2[a] > b) {
                minConflict2[a] = b
            }
        }

        var result = 0L
        val deleteCounts = LongArray(n + 1)
        var pivotIndex = n
        var minSecond = Int.MAX_VALUE

        for (i in n downTo 1) {
            if (minConflict1[pivotIndex] > minConflict1[i]) {
                minSecond = minSecond.coerceAtMost(minConflict1[pivotIndex])
                pivotIndex = i
            } else {
                minSecond = minSecond.coerceAtMost(minConflict1[i])
            }

            val end = minConflict1[pivotIndex].coerceAtMost(n + 1)
            result += (end - i)

            val upperBound = minSecond.coerceAtMost(minConflict2[pivotIndex]).coerceAtMost(n + 1)
            deleteCounts[pivotIndex] += (upperBound - end)
        }

        val maxDelete = deleteCounts.maxOrNull() ?: 0L
        return result + maxDelete
    }
}
