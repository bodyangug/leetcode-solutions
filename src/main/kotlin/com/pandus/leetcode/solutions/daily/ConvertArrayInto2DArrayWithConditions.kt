package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
class ConvertArrayInto2DArrayWithConditions {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val freqMap = LinkedHashMap<Int, Int>()
        nums.forEach { freqMap[it] = freqMap.getOrDefault(it, 0) + 1 }

        val result = ArrayList<List<Int>>()
        val rowCount = freqMap.values.max()
        for (i in 0..<rowCount) {
            val row = mutableSetOf<Int>()
            for (entry in freqMap.entries) {
                if (entry.value > 0) {
                    val add = row.add(entry.key)
                    if (add) {
                        val lastVal = freqMap[entry.key]!!
                        freqMap[entry.key] = lastVal - 1
                    }
                }
            }
            result.add(row.toList())
        }
        return result
    }
}
