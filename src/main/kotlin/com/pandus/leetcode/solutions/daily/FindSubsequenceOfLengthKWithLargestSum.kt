package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum
class FindSubsequenceOfLengthKWithLargestSum {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        data class Element(val index: Int, val value: Int)

        // Step 1: map each number to its index and value
        val elements = nums.mapIndexed { index, value -> Element(index, value) }

        // Step 2: sort by value descending, take top-k
        val topK = elements
            .sortedByDescending { it.value }
            .take(k)

        // Step 3: sort selected elements by index to preserve order
        return topK
            .sortedBy { it.index }
            .map { it.value }
            .toIntArray()
    }
}
