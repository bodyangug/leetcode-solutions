package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/closest-equal-element-queries
class ClosestEqualElementQueries {
    fun solveQueries(nums: IntArray, queries: IntArray): List<Int> {
        val n = nums.size
        val valueToIndices = mutableMapOf<Int, MutableList<Int>>()
        for (i in nums.indices) {
            valueToIndices.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
        }

        return queries.map { queryIndex ->
            val value = nums[queryIndex]
            val indices = valueToIndices[value] ?: return@map -1
            if (indices.size == 1) return@map -1

            // Binary search for the position of queryIndex in the sorted indices list
            val pos = indices.binarySearch(queryIndex)
            var minDistance = Int.MAX_VALUE

            // Check immediate neighbors (predecessor and successor) in the indices list
            val candidates = listOf(
                if (pos > 0) indices[pos - 1] else indices[indices.size - 1],
                if (pos < indices.size - 1) indices[pos + 1] else indices[0]
            )
            for (index in candidates) {
                val directDistance = kotlin.math.abs(index - queryIndex)
                val circularDistance = n - directDistance
                minDistance = minOf(minDistance, minOf(directDistance, circularDistance))
            }
            minDistance
        }
    }
}
