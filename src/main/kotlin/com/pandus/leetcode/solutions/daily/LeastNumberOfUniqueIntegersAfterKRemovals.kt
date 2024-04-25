package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals
class LeastNumberOfUniqueIntegersAfterKRemovals {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val frequencies = arr.groupBy { it }.values.map { it.size }.sorted()
        var elementsRemoved = 0
        frequencies.forEachIndexed { index, frequency ->
            elementsRemoved += frequency
            if (elementsRemoved > k) {
                return frequencies.size - index
            }
        }
        return 0
    }
}
