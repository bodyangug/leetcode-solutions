package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-elements-with-maximum-frequency
class CountElementsWithMaximumFrequency {
    fun maxFrequencyElements(nums: IntArray): Int {
        val freqMap = LinkedHashMap<Int, Int>().apply {
            nums.forEach { this[it] = this.getOrDefault(it, 0) + 1 }
        }
        return freqMap.maxOf { it.value }.let { max -> freqMap.values.filter { it == max }.sum() }
    }
}
