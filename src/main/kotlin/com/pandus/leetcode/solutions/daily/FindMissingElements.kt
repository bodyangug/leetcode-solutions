package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-missing-elements
class FindMissingElements {
    fun findMissingElements(nums: IntArray): List<Int> {
        val missingElements = mutableListOf<Int>()
        val min = nums.minOrNull() ?: return missingElements
        val max = nums.maxOrNull() ?: return missingElements
        val numSet = nums.toSet()
        for (i in min..max) {
            if (i !in numSet) {
                missingElements.add(i)
            }
        }
        return missingElements
    }
}
