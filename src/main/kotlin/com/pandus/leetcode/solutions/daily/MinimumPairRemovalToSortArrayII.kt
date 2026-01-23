package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-ii
class MinimumPairRemovalToSortArrayII {
    fun minimumPairRemoval(nums: IntArray): Int {
        if (nums.size <= 1) return 0

        var operations = 0
        val list = nums.toMutableList()

        while (!isNonDecreasing(list)) {
            val minPairIndex = findMinPairIndex(list)
            val sum = list[minPairIndex] + list[minPairIndex + 1]
            list.removeAt(minPairIndex)
            list[minPairIndex] = sum
            operations++
        }
        return operations
    }

    private fun isNonDecreasing(list: List<Int>): Boolean {
        for (i in 1 until list.size) {
            if (list[i] < list[i - 1]) {
                return false
            }
        }
        return true
    }

    private fun findMinPairIndex(list: List<Int>): Int {
        var minSum = Int.MAX_VALUE
        var minIndex = 0
        for (i in 0 until list.size - 1) {
            val sum = list[i] + list[i + 1]
            if (sum < minSum) {
                minSum = sum
                minIndex = i
            }
        }
        return minIndex
    }
}
