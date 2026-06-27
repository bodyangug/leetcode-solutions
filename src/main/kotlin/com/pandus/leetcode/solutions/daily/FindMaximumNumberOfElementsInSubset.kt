package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset
class FindMaximumNumberOfElementsInSubset {
    fun maximumLength(nums: IntArray): Int {
        val frequency = mutableMapOf<Long, Int>()
        for (num in nums) {
            val key = num.toLong()
            frequency[key] = (frequency[key] ?: 0) + 1
        }

        var maxLength = 1
        val onesCount = frequency[1L] ?: 0
        if (onesCount > 0) {
            maxLength = maxOf(maxLength, if (onesCount % 2 == 0) onesCount - 1 else onesCount)
        }

        for ((value, count) in frequency) {
            if (value == 1L || count == 0) {
                continue
            }

            var current = value
            var chainLength = 0
            while ((frequency[current] ?: 0) >= 2) {
                chainLength += 2
                current *= current
            }

            chainLength += if ((frequency[current] ?: 0) >= 1) 1 else -1
            maxLength = maxOf(maxLength, chainLength)
        }

        return maxLength
    }
}
