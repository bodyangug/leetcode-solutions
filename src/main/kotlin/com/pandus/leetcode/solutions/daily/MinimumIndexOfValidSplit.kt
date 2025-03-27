package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-index-of-a-valid-split
class MinimumIndexOfValidSplit {
    fun minimumIndex(nums: List<Int?>): Int {
        val n = nums.size
        // Frequency map for the "right" side initially includes all elements.
        val rightFreq = nums.groupingBy { it }.eachCount().toMutableMap()
        // Frequency map for the "left" side starts empty.
        val leftFreq = mutableMapOf<Int?, Int>()

        for ((index, num) in nums.withIndex()) {
            // Move one occurrence of 'num' from rightFreq to leftFreq
            rightFreq[num] = rightFreq[num]!! - 1
            leftFreq[num] = leftFreq.getOrDefault(num, 0) + 1

            // Check if this index creates a valid split.
            // left side: indices 0..index (inclusive) -> size = index + 1
            // right side: indices index+1..n-1 -> size = n - (index + 1)
            if (leftFreq[num]!! * 2 > (index + 1) &&
                rightFreq[num]!! * 2 > (n - (index + 1))
            ) {
                return index
            }
        }
        return -1
    }
}
