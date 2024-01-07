package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty
class MinimumNumberOfOperationsToMakeArrayEmpty {
    fun minOperations(nums: IntArray): Int {
        val linkMap = nums.withIndex().groupBy({ it.value }, { it.index }).toMutableMap()
        var totalOperations = 0
        var wasRemoved = 0
        for ((num, indices) in linkMap) {
            var size = indices.size
            var pointer = 0
            while (size > 0) {
                val idxs = linkMap[num]!!
                val dropCount = if (size % 3 == 0) 3 else 2
                if (size == 1) return -1
                totalOperations += 1
                size -= dropCount
                wasRemoved += dropCount
                pointer += dropCount
            }
        }
        if (wasRemoved < nums.size) {
            return -1
        }
        return totalOperations
    }
}
