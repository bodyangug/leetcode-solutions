package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sort-array-by-increasing-frequency
class SortArrayByIncreasingFrequency {
    fun frequencySort(nums: IntArray): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>().apply {
            for (num in nums) {
                this[num] = this.getOrDefault(num, 0) + 1
            }
        }
        return nums.sortedWith(compareBy({ frequencyMap[it] }, { -it })).toIntArray()
    }
}
