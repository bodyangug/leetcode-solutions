package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-absolute-difference
class MinimumAbsoluteDifference {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        val minDiff = arr.asSequence()
            .zipWithNext { a, b -> b - a }
            .minOrNull() ?: return emptyList()
        return arr.asSequence()
            .zipWithNext()
            .filter { (a, b) -> b - a == minDiff }
            .map { listOf(it.first, it.second) }
            .toList()
    }
}
