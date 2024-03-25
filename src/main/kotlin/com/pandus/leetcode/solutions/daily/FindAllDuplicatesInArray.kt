package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/find-all-duplicates-in-an-array
class FindAllDuplicatesInArray {
    fun findDuplicates(nums: IntArray): List<Int> {
        val freqMap = LinkedHashMap<Int, Int>().apply {
            nums.forEach { this[it] = this.getOrDefault(it, 0) + 1 }
        }
        return freqMap.entries.filter { it.value > 1 }.map { it.key }
    }
}
